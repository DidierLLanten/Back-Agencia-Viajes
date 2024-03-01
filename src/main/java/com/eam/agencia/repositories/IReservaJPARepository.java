package com.eam.agencia.repositories;

import com.eam.agencia.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IReservaJPARepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM Reserva r WHERE r.paqueteTuristico.nombre = ?1")
    List<Reserva> findReservasByPaqueteTuristiconNombre(String nombrePaquete);

    @Query("SELECT r FROM Reserva r WHERE r.paqueteTuristico.id = ?1")
    List<Reserva> findByPaqueteTuristicoId(int paqueteTuristicoId);

    @Query("SELECT r FROM Reserva r WHERE r.cliente.identificacion = ?1")
    List<Reserva> findByClienteIdentificacion(String identificacionCliente);
}
