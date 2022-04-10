package com.alugueldecarros.alugueldecarros.controller;

import com.alugueldecarros.alugueldecarros.model.Cliente;
import com.alugueldecarros.alugueldecarros.repositories.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ClienteController {

    private ClienteRepositorio clienteRepo;

    public ClienteController(ClienteRepositorio clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("listaClientes",clienteRepo.findAll());
        return "clientes/index";
    }

    @GetMapping("/clientes/nova")
    public String novoCliente(@ModelAttribute("cliente") Cliente cliente) {
        return "clientes/form";
    }

    @GetMapping("/clientes/{id}")
    public String alterarCliente(@PathVariable("id") long id, Model model){
        Optional<Cliente> clienteOpt = clienteRepo.findById(id);
        if (clienteOpt.isEmpty()){
            throw new IllegalArgumentException("Cliente invalido!");
        }
        model.addAttribute("cliente", clienteOpt.get());
        return "clientes/form";
    }

    @PostMapping("/clientes/salvar")
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepo.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/excluir/{id}")
    public String deletarCliente(@PathVariable("id") long id){
        Optional<Cliente> clienteOpt = clienteRepo.findById(id);
        if (clienteOpt.isEmpty()){
            throw new IllegalArgumentException("Cliente invalido!");
        }
        clienteRepo.delete(clienteOpt.get());
        return "redirect:/clientes";
    }
}
