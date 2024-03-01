package com.eam.agencia.controllers;

import com.eam.agencia.models.Cliente;
import com.eam.agencia.services.interfaces.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> createCliente(@RequestBody Cliente cliente){
        if (cliente.getIdentificacion() == null) {
            return ResponseEntity.badRequest().body("El campo 'identificacion' es requerido");
        }
        Cliente newCliente = clienteService.createCliente(cliente);
        return ResponseEntity.ok("{\"message\": \"Cliente creado con éxito\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@RequestBody Cliente cliente, @PathVariable int id){
        Cliente clienteUpdated = clienteService.updateCliente(id, cliente);
        if(clienteUpdated != null){
            return ResponseEntity.ok("{\"message\": \"Cliente modificado con éxito\"}");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable int id){
        clienteService.deleteCliente(id);
        return ResponseEntity.ok("{\"message\": \"Cliente eliminado con éxito\"}");
    }

    @DeleteMapping("identificacion/{identificacion}")
    public ResponseEntity<String> deleteCliente(@PathVariable String identificacion){
        clienteService.deleteCliente(identificacion);
        return ResponseEntity.ok("{\"message\": \"Cliente eliminado con éxito\"}");
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes = clienteService.getAllClientes();
        if(clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id){
        Cliente cliente = clienteService.getClienteById(id);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/identificacion/{identificacion}")
    public ResponseEntity<Cliente> getClienteByIdentificacion(@PathVariable String identificacion){
        Cliente cliente = clienteService.getClienteByIdentificacion(identificacion);
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Cliente>> getClientesByNombre(@PathVariable String nombre){
        List<Cliente> clientes = clienteService.getClientesByNombre(nombre);
        if(clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Cliente>> getClientesByEmail(@PathVariable String email){
        List<Cliente> clientes = clienteService.getClientesByEmail(email);
        if(clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

}
