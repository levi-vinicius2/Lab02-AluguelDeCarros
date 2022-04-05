package com.alugueldecarros.alugueldecarros.cliente.controller;

import com.alugueldecarros.alugueldecarros.cliente.model.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
