package com.eam.agencia.services.interfaces;

import com.eam.agencia.models.Reserva;
import java.util.List;
import java.util.Optional;

public interface IReservaService {
    public Reserva createReserva(Reserva reserva);
    public Reserva updateReserva(int id, Reserva reserva);
    public void deleteReserva(int id);
    public Optional<Reserva> getReservaById(int id);
    public List<Reserva> getReservaByClienteIdentificacion(String identificacion);
    public List<Reserva> getAllReservas();
}
