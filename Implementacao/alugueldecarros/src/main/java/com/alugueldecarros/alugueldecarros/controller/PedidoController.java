package com.alugueldecarros.alugueldecarros.controller;

import com.alugueldecarros.alugueldecarros.model.Cliente;
import com.alugueldecarros.alugueldecarros.model.Pedido;
import com.alugueldecarros.alugueldecarros.model.Usuario;
import com.alugueldecarros.alugueldecarros.repositories.PedidoRepositorio;
import com.alugueldecarros.alugueldecarros.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
public class PedidoController {

    private PedidoRepositorio pedidoRepo;

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    public PedidoController(PedidoRepositorio pedidoRepo){
        this.pedidoRepo = pedidoRepo;
    }


    @GetMapping("/pedidos")
    public String pedidos(Model model, Principal principal) {
        Usuario u1 = usuarioRepo.findByUsername(principal.getName());
        model.addAttribute("listaPedidos",pedidoRepo.findByUsuarioId(u1.getId()));
        return "pedidos/index";
    }

    @GetMapping("/pedidos/novo")
    public String novoPedido(@ModelAttribute("pedido") Pedido pedido) {
        return "pedidos/form";
    }


    @GetMapping("/pedidos/{id}")
    public String alterarPedido(@PathVariable("id") long id, Model model){
        Optional<Pedido> PedidoOpt = pedidoRepo.findById(id);
        if (PedidoOpt.isEmpty()){
            throw new IllegalArgumentException("Pedido invalido!");
        }
        model.addAttribute("pedidos", PedidoOpt.get());
        return "pedidos/form";
    }

    @PostMapping("/pedidos/salvar")
    public String salvarPedido(@ModelAttribute("pedidos") Pedido pedido) {
        pedidoRepo.save(pedido);
        return "redirect:/pedidos";
    }


    @GetMapping("/pedidos/excluir/{id}")
    public String deletarPedido(@PathVariable("id") long id){
        Optional<Pedido> PedidoOpt  = pedidoRepo.findById(id);
        if (PedidoOpt.isEmpty()){
            throw new IllegalArgumentException("Pedido invalido!");
        }
        pedidoRepo.delete(PedidoOpt.get());
        return "redirect:/pedidos";
    }
}
