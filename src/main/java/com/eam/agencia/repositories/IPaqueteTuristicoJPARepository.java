package com.eam.agencia.repositories;

import com.eam.agencia.models.PaqueteTuristico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPaqueteTuristicoJPARepository extends JpaRepository<PaqueteTuristico, Integer> {
    List<PaqueteTuristico> findPaqueteTuristicosByNombre(String nombre);

    List<PaqueteTuristico> findPaqueteTuristicosByPrecio(double precio);

    List<PaqueteTuristico> findPaqueteTuristicosByFechaInicio(LocalDateTime fechaInicio);
}
