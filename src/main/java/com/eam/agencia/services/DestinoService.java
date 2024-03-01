package com.eam.agencia.services;

import com.eam.agencia.models.Destino;
import com.eam.agencia.repositories.IDestinoJPARepository;
import com.eam.agencia.services.interfaces.IDestinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DestinoService implements IDestinoService {

    private final IDestinoJPARepository destinoJPARepository;

    @Override
    public Destino createDestino(Destino destino) {
        return destinoJPARepository.save(destino);
    }

    @Override
    public Destino updateDestino(int id, Destino destino) {
        Optional<Destino> currentDestino = getDestinoById(id);
        if (currentDestino.isPresent()) {
            currentDestino.get().setNombre(destino.getNombre());
            currentDestino.get().setImagen(destino.getImagen());
            return destinoJPARepository.save(currentDestino.get());
        }
        return null;
    }

    @Override
    public void deleteDestino(int id) {
        destinoJPARepository.deleteById(id);
    }

    @Override
    public Optional<Destino> getDestinoById(int id) {
        return destinoJPARepository.findById(id);
    }

    @Override
    public List<Destino> getDestinosByNombre(String nombre) {
        return destinoJPARepository.findDestinoByNombre(nombre);
    }

    @Override
    public List<Destino> getAllDestinos() {
        return destinoJPARepository.findAll();
    }
}
