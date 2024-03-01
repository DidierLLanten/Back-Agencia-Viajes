package com.eam.agencia.services;

import com.eam.agencia.models.Destino;
import com.eam.agencia.models.PaqueteTuristico;
import com.eam.agencia.repositories.IPaqueteTuristicoJPARepository;
import com.eam.agencia.services.interfaces.IPaqueteTuristicoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaqueteTuristicoService implements IPaqueteTuristicoService {
    @PersistenceContext
    private EntityManager entityManager;

    private final IPaqueteTuristicoJPARepository paqueteTuristicoJPARepository;

    @Override
    public PaqueteTuristico createPaqueteTuristico(PaqueteTuristico paqueteTuristico) {

        List<Destino> destinos = new ArrayList<>();
        for (Destino destino : paqueteTuristico.getDestinos()) {
            Destino managedDestino = entityManager.find(Destino.class, destino.getId());
            if (managedDestino == null) {
                return null;
            }
            destinos.add(managedDestino);
        }

        paqueteTuristico.setDestinos(destinos);
        return paqueteTuristicoJPARepository.save(paqueteTuristico);
    }

    @Override
    public PaqueteTuristico updatePaqueteTuristico(int id, PaqueteTuristico paqueteTuristico) {
        Optional<PaqueteTuristico> currentPaqueteTuristico = getPaqueteTuristicoById(id);
        if (currentPaqueteTuristico.isPresent()) {
            currentPaqueteTuristico.get().setNombre(paqueteTuristico.getNombre());
            currentPaqueteTuristico.get().setCupoMaximo(paqueteTuristico.getCupoMaximo());
            currentPaqueteTuristico.get().setDuracion(paqueteTuristico.getDuracion());
            currentPaqueteTuristico.get().setDestinos(paqueteTuristico.getDestinos());
            currentPaqueteTuristico.get().setFechaInicio(paqueteTuristico.getFechaInicio());
            currentPaqueteTuristico.get().setPrecio(paqueteTuristico.getPrecio());
            return paqueteTuristicoJPARepository.save(currentPaqueteTuristico.get());
        }
        return null;
    }

    @Override
    public void deletePaqueteTuristico(int id) {
        paqueteTuristicoJPARepository.deleteById(id);
    }

    @Override
    public Optional<PaqueteTuristico> getPaqueteTuristicoById(int id) {
        return paqueteTuristicoJPARepository.findById(id);
    }

    @Override
    public List<PaqueteTuristico> getPaquetesTuristicosByNombre(String nombre) {
        return paqueteTuristicoJPARepository.findPaqueteTuristicosByNombre(nombre);
    }

    @Override
    public List<PaqueteTuristico> getAllPaquetesTuristicos() {
        return paqueteTuristicoJPARepository.findAll();
    }

    @Override
    public List<PaqueteTuristico> getPaquetesTuristicosByPrecio(double precio) {
        return paqueteTuristicoJPARepository.findPaqueteTuristicosByPrecio(precio);
    }

    @Override
    public List<PaqueteTuristico> getPaquetesTuristicosByFechaIncio(LocalDateTime fechaIncio) {
        return paqueteTuristicoJPARepository.findPaqueteTuristicosByFechaInicio(fechaIncio);
    }
}
