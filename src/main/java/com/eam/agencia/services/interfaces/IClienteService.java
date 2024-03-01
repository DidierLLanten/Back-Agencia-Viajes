package com.eam.agencia.services.interfaces;

import com.eam.agencia.models.Cliente;
import java.util.List;

public interface IClienteService {
    public Cliente createCliente(Cliente cliente);
    public Cliente updateCliente(int id, Cliente cliente);
    public void deleteCliente(int id);
    public void deleteCliente(String identificacion);
    public Cliente getClienteById(int id);
    public Cliente getClienteByIdentificacion(String identificacion);
    public List<Cliente> getAllClientes();
    public List<Cliente> getClientesByNombre(String nombre);
    public List<Cliente> getClientesByEmail(String email);
}
