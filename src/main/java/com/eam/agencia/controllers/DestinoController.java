package com.eam.agencia.controllers;

import com.eam.agencia.models.Cliente;
import com.eam.agencia.models.Destino;
import com.eam.agencia.services.interfaces.IDestinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/destino")
@RequiredArgsConstructor
public class DestinoController {

    private final IDestinoService destinoService;

    @PostMapping
    public ResponseEntity<String> createDestino(@RequestBody Destino destino){
        if (destino.getNombre() == null) {
            return ResponseEntity.badRequest().body("El campo 'destino' es requerido");
        }
        Destino newDestino = destinoService.createDestino(destino);
        return ResponseEntity.ok("{\"message\": \"Destino creado con éxito\"}");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDestino(@RequestBody Destino destino, @PathVariable int id){
        Destino destinoUpdated = destinoService.updateDestino(id, destino);
        if(destinoUpdated != null){
            return ResponseEntity.ok("{\"message\": \"Destino modificado con éxito\"}");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDestino(@PathVariable int id){
        destinoService.deleteDestino(id);
        return ResponseEntity.ok("{\"message\": \"Destino eliminado con éxito\"}");
    }

    @GetMapping
    public ResponseEntity<List<Destino>> getAllDestino(){
        List<Destino> destinos = destinoService.getAllDestinos();
        if(destinos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(destinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestinoById(@PathVariable int id){
        Optional<Destino> destino = destinoService.getDestinoById(id);
        return destino.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Destino>> getDestinosByNombre(@PathVariable String nombre){
        List<Destino> destinos = destinoService.getDestinosByNombre(nombre);
        if(destinos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(destinos);
    }

}
