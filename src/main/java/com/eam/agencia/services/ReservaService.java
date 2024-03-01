package com.eam.agencia.services;

import com.eam.agencia.models.PaqueteTuristico;
import com.eam.agencia.models.Reserva;
import com.eam.agencia.repositories.IReservaJPARepository;
import com.eam.agencia.services.interfaces.IPaqueteTuristicoService;
import com.eam.agencia.services.interfaces.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService {

    private final IReservaJPARepository reservaJPARepository;
    private final IPaqueteTuristicoService paqueteTuristicoService;
    @Override
    public Reserva createReserva(Reserva reserva) {
//        List<Reserva> reservas= reservaJPARepository.findReservasByPaqueteTuristiconNombre(reserva.getPaqueteTuristico().getNombre());

        List<Reserva> reservas= reservaJPARepository.findByPaqueteTuristicoId(reserva.getPaqueteTuristico().getId());
        Optional<PaqueteTuristico> auxPaqueteTuristico = paqueteTuristicoService.getPaqueteTuristicoById(reserva.getPaqueteTuristico().getId());

        int auxCupoMaximo = auxPaqueteTuristico.get().getCupoMaximo();

        int auxCantidadPersonas = 0;
        for (Reserva auxReserva:reservas) {
            auxCantidadPersonas += auxReserva.getCantidadPersonas();
        }
        if((auxCantidadPersonas + reserva.getCantidadPersonas()) <= auxCupoMaximo){
            return reservaJPARepository.save(reserva);
        }

        return null;
    }

    @Override
    public Reserva updateReserva(int id, Reserva reserva) {
        Optional<Reserva> currentReserva = getReservaById(id);
        if (currentReserva.isPresent()) {
            currentReserva.get().setCliente(reserva.getCliente());
            currentReserva.get().setCantidadPersonas(reserva.getCantidadPersonas());
            currentReserva.get().setPaqueteTuristico(reserva.getPaqueteTuristico());
            return reservaJPARepository.save(currentReserva.get());
        }
        return null;
    }

    @Override
    public void deleteReserva(int id) {
        reservaJPARepository.deleteById(id);
    }

    @Override
    public Optional<Reserva> getReservaById(int id) {
        return reservaJPARepository.findById(id);
    }

    @Override
    public List<Reserva> getReservaByClienteIdentificacion(String identificacion) {
        return reservaJPARepository.findByClienteIdentificacion(identificacion);
    }

    @Override
    public List<Reserva> getAllReservas() {
        return reservaJPARepository.findAll();
    }
}
