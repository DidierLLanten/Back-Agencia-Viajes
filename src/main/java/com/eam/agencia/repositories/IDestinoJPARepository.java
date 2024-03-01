package com.eam.agencia.repositories;

import com.eam.agencia.models.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDestinoJPARepository extends JpaRepository<Destino,Integer> {
    List<Destino> findDestinoByNombre(String nombre);
}
