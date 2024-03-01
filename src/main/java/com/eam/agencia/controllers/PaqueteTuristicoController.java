package com.eam.agencia.controllers;

import com.eam.agencia.models.PaqueteTuristico;
import com.eam.agencia.services.interfaces.IPaqueteTuristicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paquete-turistico/admin")
@RequiredArgsConstructor
public class PaqueteTuristicoController {

    private final IPaqueteTuristicoService paqueteTuristicoService;

    @PostMapping
    public ResponseEntity<String> createPaqueteTuristico(@RequestBody PaqueteTuristico paqueteTuristico){
        if (paqueteTuristico.getNombre() == null) {
            return ResponseEntity.badRequest().body("El campo 'nombre' es requerido");
        }
        PaqueteTuristico newPaqueteTuristico = paqueteTuristicoService.createPaqueteTuristico(paqueteTuristico);
        if(newPaqueteTuristico != null){
            return ResponseEntity.ok("{\"message\": \"Paquete turistico creado con éxito\"}");
        }
        return ResponseEntity.badRequest().body("No se pudo crear el Paquete turistico.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePaqueteTuristico(@RequestBody PaqueteTuristico paqueteTuristico, @PathVariable int id){
        PaqueteTuristico paqueteTuristicoUpdated = paqueteTuristicoService.updatePaqueteTuristico(id, paqueteTuristico);
        if(paqueteTuristicoUpdated != null){
            return ResponseEntity.ok("{\"message\": \"Paquete turistico modificado con éxito\"}");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaqueteTuristico(@PathVariable int id){
        paqueteTuristicoService.deletePaqueteTuristico(id);
        return ResponseEntity.ok("{\"message\": \"PaqueteTuristico eliminado con éxito\"}");
    }

    @GetMapping
    public ResponseEntity<List<PaqueteTuristico>> getAllPaqueteTuristico(){
        List<PaqueteTuristico> paqueteTuristicos = paqueteTuristicoService.getAllPaquetesTuristicos();
        if(paqueteTuristicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paqueteTuristicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteTuristico> getPaqueteTuristicoById(@PathVariable int id){
        Optional<PaqueteTuristico> paqueteTuristico = paqueteTuristicoService.getPaqueteTuristicoById(id);
        return paqueteTuristico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<PaqueteTuristico>> getPaqueteTuristicosByNombre(@PathVariable String nombre){
        List<PaqueteTuristico> paqueteTuristicos = paqueteTuristicoService.getPaquetesTuristicosByNombre(nombre);
        if(paqueteTuristicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paqueteTuristicos);
    }

    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<PaqueteTuristico>> getPaqueteTuristicosByPrecio(@PathVariable double precio){
        List<PaqueteTuristico> paqueteTuristicos = paqueteTuristicoService.getPaquetesTuristicosByPrecio(precio);
        if(paqueteTuristicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paqueteTuristicos);
    }
    //http://localhost:8080/paquete-turistico/admin/fecha-incio/2024-08-26T10:00
    @GetMapping("/fecha-incio/{fechaInicio}")
    public ResponseEntity<List<PaqueteTuristico>> getPaqueteTuristicosByFechaInicio(@PathVariable LocalDateTime fechaInicio){
        List<PaqueteTuristico> paqueteTuristicos = paqueteTuristicoService.getPaquetesTuristicosByFechaIncio(fechaInicio);
        if(paqueteTuristicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paqueteTuristicos);
    }

}
