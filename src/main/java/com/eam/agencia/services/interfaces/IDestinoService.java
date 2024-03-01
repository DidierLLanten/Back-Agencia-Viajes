package com.eam.agencia.services.interfaces;

import com.eam.agencia.models.Destino;
import java.util.List;
import java.util.Optional;

public interface IDestinoService {
    public Destino createDestino(Destino destino);
    public Destino updateDestino(int id, Destino destino);
    public void deleteDestino(int id);
    public Optional<Destino> getDestinoById(int id);
    public List<Destino> getDestinosByNombre(String nombre);
    public List<Destino> getAllDestinos();
}
