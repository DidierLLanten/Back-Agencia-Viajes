package com.eam.agencia.repositories;

import com.eam.agencia.models.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IClienteJPARepository extends JpaRepository<Cliente,Integer> {
    Cliente findClienteById(int id);
    Cliente findClienteByIdentificacion(String identificacion);
    List<Cliente> findClienteByNombre(String nombre);
    List<Cliente> findClienteByEmail(String email);
    @Transactional
    void deleteClienteByIdentificacion(String identificacion);
}
