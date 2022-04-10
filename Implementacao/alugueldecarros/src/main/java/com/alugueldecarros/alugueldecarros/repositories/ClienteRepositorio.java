package com.alugueldecarros.alugueldecarros.repositories;

import com.alugueldecarros.alugueldecarros.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
