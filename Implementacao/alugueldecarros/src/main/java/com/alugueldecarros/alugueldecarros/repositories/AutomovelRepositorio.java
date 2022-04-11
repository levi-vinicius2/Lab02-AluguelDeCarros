package com.alugueldecarros.alugueldecarros.repositories;

import com.alugueldecarros.alugueldecarros.model.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovelRepositorio extends JpaRepository<Automovel, Long> {
}
