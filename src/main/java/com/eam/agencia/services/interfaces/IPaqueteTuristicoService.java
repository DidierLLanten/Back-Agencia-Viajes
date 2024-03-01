package com.eam.agencia.services.interfaces;

import com.eam.agencia.models.PaqueteTuristico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IPaqueteTuristicoService {
    public PaqueteTuristico createPaqueteTuristico(PaqueteTuristico paqueteTuristico);
    public PaqueteTuristico updatePaqueteTuristico(int id, PaqueteTuristico paqueteTuristico);
    public void deletePaqueteTuristico(int id);
    public Optional<PaqueteTuristico> getPaqueteTuristicoById(int id);
    public List<PaqueteTuristico> getPaquetesTuristicosByNombre(String nombre);
    public List<PaqueteTuristico> getAllPaquetesTuristicos();
    public List<PaqueteTuristico> getPaquetesTuristicosByPrecio(double precio);
    public List<PaqueteTuristico> getPaquetesTuristicosByFechaIncio(LocalDateTime fechaIncio);
}
