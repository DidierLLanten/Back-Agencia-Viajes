package com.eam.agencia.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="\"reserva\"")
public class Reserva {
    /*Cuando se guarda la reserva debe quedar registrada la fecha, el
    cliente y el paquete turístico elegido.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="fecha_compra")
    private LocalDateTime fechaCompra = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name ="cantidad_personas")
    private int cantidadPersonas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_paqueteTuristico")
    private PaqueteTuristico paqueteTuristico;
}
