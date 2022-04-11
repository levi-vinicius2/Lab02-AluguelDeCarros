package com.alugueldecarros.alugueldecarros.repositories;

import com.alugueldecarros.alugueldecarros.model.Pedido;
import com.alugueldecarros.alugueldecarros.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio  extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuarioId(Long usuario);
}
