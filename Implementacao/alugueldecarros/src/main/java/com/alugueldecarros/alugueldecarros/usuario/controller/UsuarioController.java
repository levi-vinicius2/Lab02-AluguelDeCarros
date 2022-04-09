package com.alugueldecarros.alugueldecarros.usuario.controller;

import com.alugueldecarros.alugueldecarros.usuario.model.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;
import com.alugueldecarros.alugueldecarros.usuario.model.Role;


@Controller
public class UsuarioController {

    private PasswordEncoder encoder;
    private UsuarioRepositorio usuarioRepo;
    private final List<String> roles;

    public UsuarioController(UsuarioRepositorio usuarioRepo, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.usuarioRepo = usuarioRepo;
        this.roles = Role.getRoles();
    }

    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "/login";
    }

}