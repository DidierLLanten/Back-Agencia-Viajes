package com.eam.agencia.services;

import com.eam.agencia.models.Cliente;
import com.eam.agencia.repositories.IClienteJPARepository;
import com.eam.agencia.services.interfaces.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteJPARepository clienteRepository;
    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(int id, Cliente cliente) {
        Cliente currentCliente = getClienteById(id);
        System.out.println("Cliente buscado sevice: " + currentCliente);
        if(currentCliente == null){
            return null;
        }
        currentCliente.setNombre(cliente.getNombre());
        currentCliente.setEmail(cliente.getEmail());
        return clienteRepository.save(currentCliente);
    }

    @Override
    public void deleteCliente(int id) {
        System.out.println("Delete con int");
        clienteRepository.deleteById(id);
    }

    @Override
    public void deleteCliente(String identificacion) {
        System.out.println("Delete con string");
        clienteRepository.deleteClienteByIdentificacion(identificacion);
    }

    @Override
    public Cliente getClienteById(int id) {
        return clienteRepository.findClienteById(id);
    }

    @Override
    public Cliente getClienteByIdentificacion(String identificacion) {
        return clienteRepository.findClienteByIdentificacion(identificacion);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> getClientesByNombre(String nombre) {
        return clienteRepository.findClienteByNombre(nombre);
    }

    @Override
    public List<Cliente> getClientesByEmail(String email) {
        return clienteRepository.findClienteByEmail(email);
    }
}
