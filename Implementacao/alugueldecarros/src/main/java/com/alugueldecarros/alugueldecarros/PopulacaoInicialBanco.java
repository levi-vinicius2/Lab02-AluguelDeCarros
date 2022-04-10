package com.alugueldecarros.alugueldecarros;

import com.alugueldecarros.alugueldecarros.model.Role;
import com.alugueldecarros.alugueldecarros.model.Usuario;
import com.alugueldecarros.alugueldecarros.repositories.ClienteRepositorio;
import com.alugueldecarros.alugueldecarros.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

    @Autowired
    private ClienteRepositorio clienteRepo;

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {


//        Cliente c1 = new Cliente("Joao");
//        c1.setCpf("11111111111");
//        c1.setRg("MG123123123");
//        c1.setEndereco("rua São Paulo");
//        c1.setProfissao("Programador");
//        c1.setEmpregador("Lucas");
//        c1.setRendimento_1(3200);
//        Cliente c2 = new Cliente("Maria");
//        c2.setCpf("2222222222");
//        c2.setRg("MG12665334");
//        c2.setEndereco("Rua 123");
//        c2.setProfissao("Gerente");
//        c2.setEmpregador("Luis");
//        c2.setRendimento_1(4300);
//
//        clienteRepo.save(c1);
//        clienteRepo.save(c2);

//        Usuario u1 = new Usuario("admin", passwordEncoder.encode("admin"));
//        u1.setRole(Role.ADMIN.getNome());
//        usuarioRepo.save(u1);
//
//        Usuario u2 = new Usuario("joao", passwordEncoder.encode("joao"));
//        u2.setRole(Role.CLIENTE.getNome());
//        usuarioRepo.save(u2);


    }
}
