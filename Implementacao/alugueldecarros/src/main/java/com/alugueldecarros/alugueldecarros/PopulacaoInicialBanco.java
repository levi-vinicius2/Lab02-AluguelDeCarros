package com.alugueldecarros.alugueldecarros;

import com.alugueldecarros.alugueldecarros.model.Automovel;
import com.alugueldecarros.alugueldecarros.model.Pedido;
import com.alugueldecarros.alugueldecarros.model.Role;
import com.alugueldecarros.alugueldecarros.model.Usuario;
import com.alugueldecarros.alugueldecarros.repositories.AutomovelRepositorio;
import com.alugueldecarros.alugueldecarros.repositories.ClienteRepositorio;
import com.alugueldecarros.alugueldecarros.repositories.PedidoRepositorio;
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
    private PedidoRepositorio pedidoRepo;



    @Autowired
    private AutomovelRepositorio automovelRepo;


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
//
//        Automovel a1 = new Automovel("ABC12YR3");
//        a1.setAno(2021);
//        a1.setMarca("Toyota");
//        a1.setModelo("Corolla");
//        a1.setPlaca("AAA-1234");
//        Automovel a2 = new Automovel("ABC22122");
//        a2.setAno(2020);
//        a2.setMarca("Honda");
//        a2.setModelo("Fit");
//        a2.setPlaca("BBB-5444");
//        Automovel a3 = new Automovel("AYC2C2A2");
//        a3.setAno(2019);
//        a3.setMarca("Renault");
//        a3.setModelo("Logan");
//        a3.setPlaca("GGG-3421");
//        automovelRepo.save(a1);
//        automovelRepo.save(a2);
//        automovelRepo.save(a3);
//
//
//        Pedido p1 = new Pedido(u2,a1);
//        Pedido p2 = new Pedido(u2,a3);
//        pedidoRepo.save(p1);
//        pedidoRepo.save(p2);


    }
}
