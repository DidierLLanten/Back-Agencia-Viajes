package com.eam.agencia.controllers;

import com.eam.agencia.models.Reserva;
import com.eam.agencia.services.interfaces.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final IReservaService reservaService;

    @PostMapping
    public ResponseEntity<String> createReserva(@RequestBody Reserva reserva){
        if (reserva.getCliente() == null) {
            return ResponseEntity.badRequest().body("El campo 'cliente' es requerido");
        }
        Reserva newReserva = reservaService.createReserva(reserva);
        if(newReserva != null){
            return ResponseEntity.ok("{\"message\": \"Reserva creado con éxito\"}");
        }
        return ResponseEntity.badRequest().body("No hay suficientes cupos.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReserva(@RequestBody Reserva reserva, @PathVariable int id){
        Reserva reservaUpdated = reservaService.updateReserva(id, reserva);
        if(reservaUpdated != null){
            return ResponseEntity.ok("{\"message\": \"Reserva modificado con éxito\"}");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReserva(@PathVariable int id){
        reservaService.deleteReserva(id);
        return ResponseEntity.ok("{\"message\": \"Reserva eliminado con éxito\"}");
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReserva(){
        List<Reserva> reservas = reservaService.getAllReservas();
        if(reservas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id){
        Optional<Reserva> reserva = reservaService.getReservaById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente-identificacion/{identificacion}")
    public ResponseEntity<List<Reserva>> getReservaByClienteIdentificacion(@PathVariable String identificacion){
        List<Reserva> reservas = reservaService.getReservaByClienteIdentificacion(identificacion);
        return ResponseEntity.ok(reservas);
    }

}
