package com.alugueldecarros.alugueldecarros.controller;

import com.alugueldecarros.alugueldecarros.model.Automovel;
import com.alugueldecarros.alugueldecarros.model.Cliente;
import com.alugueldecarros.alugueldecarros.model.Pedido;
import com.alugueldecarros.alugueldecarros.model.Usuario;
import com.alugueldecarros.alugueldecarros.model.dtos.AutoCompleteDTO;
import com.alugueldecarros.alugueldecarros.repositories.AutomovelRepositorio;
import com.alugueldecarros.alugueldecarros.repositories.PedidoRepositorio;
import com.alugueldecarros.alugueldecarros.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class PedidoController {

    private PedidoRepositorio pedidoRepo;
    private AutomovelRepositorio automovelRepo;
    private List<Automovel> automoveisFiltrados = new ArrayList<>();

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    public PedidoController(PedidoRepositorio pedidoRepo, AutomovelRepositorio automovelRepo){
        this.pedidoRepo = pedidoRepo;
        this.automovelRepo = automovelRepo;
    }


    @GetMapping("/pedidos")
    public String pedidos(Model model, Principal principal) {
        Usuario u1 = usuarioRepo.findByUsername(principal.getName());
        model.addAttribute("listaPedidos",pedidoRepo.findByUsuarioId(u1.getId()));
        return "pedidos/index";
    }

    @GetMapping("/pedidos/novo")
    public String novoPedido(Model model, Principal principal) {

        Usuario u1 = usuarioRepo.findByUsername(principal.getName());
        model.addAttribute("pedido", new Pedido(u1));
        model.addAttribute("automoveis", automovelRepo.findAll());

        return "pedidos/form";
    }


    @GetMapping("/pedidos/{id}")
    public String alterarPedido(@PathVariable("id") long id, Model model){
        Optional<Pedido> PedidoOpt = pedidoRepo.findById(id);
        if (PedidoOpt.isEmpty()){
            throw new IllegalArgumentException("Pedido invalido!");
        }
        model.addAttribute("pedido", PedidoOpt.get());
        model.addAttribute("automoveis",  automovelRepo.findAll());
        return "pedidos/form";
    }


    @PostMapping("/pedidos/salvar")
    public String salvarPedido(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult bindingResult, Model model, Principal principal) {
        Usuario u1 = usuarioRepo.findByUsername(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("automoveis", automovelRepo.findAll());
            return "pedidos/form";
        }
        pedido.setUsuario(u1);
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
//
//    @RequestMapping("/pedidos/automovelNomeAutoComplete")
//    @ResponseBody
//    public List<AutoCompleteDTO> automovelNomeAutoComplete(@RequestParam(value="term", required = false, defaultValue = "") String term) {
//        List<AutoCompleteDTO> sugestoes = new ArrayList<>();
//
//        try {
//            if(term.length() >= 3) {
//                automoveisFiltrados = automovelRepo.searchByNome(term);
//            }
//
//            for (Automovel automovel : automoveisFiltrados) {
//                if (automovel.toString().toLowerCase().contains(term.toLowerCase())) {
//                    AutoCompleteDTO dto = new AutoCompleteDTO(automovel.toString(), Long.toString(automovel.getId()));
//                    sugestoes.add(dto);
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return sugestoes;
//    }
}
