package com.alugueldecarros.alugueldecarros.cliente.controller;

import com.alugueldecarros.alugueldecarros.cliente.model.Cliente;
import com.alugueldecarros.alugueldecarros.cliente.model.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/clientes/salvar")
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepo.save(cliente);
        return "redirect:/clientes";
    }
}