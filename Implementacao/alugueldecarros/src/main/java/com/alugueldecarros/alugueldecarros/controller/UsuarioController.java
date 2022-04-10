package com.alugueldecarros.alugueldecarros.controller;

import com.alugueldecarros.alugueldecarros.model.Role;
import com.alugueldecarros.alugueldecarros.repositories.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


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