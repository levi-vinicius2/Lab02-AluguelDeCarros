package com.alugueldecarros.alugueldecarros.repositories;

import java.util.Collection;
import java.util.List;

import com.alugueldecarros.alugueldecarros.model.Automovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovelRepositorio extends JpaRepository<Automovel, Long> {

    @Query("from Automovel where modelo = :modelo")
    Collection<Automovel> findAllByModelo(@Param("modelo") String modelo);
}