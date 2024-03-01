package com.eam.agencia.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="\"paquete_turistico\"")
public class PaqueteTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name ="fecha_inicio")
    private LocalDateTime fechaInicio;

    private int duracion;

    @Column(name ="cupo_maximo")
    private int cupoMaximo;

    private double precio;

//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany()
    @JoinTable(name = "paquete_turistico_destino",
    joinColumns = {@JoinColumn(name = "paquete_turistico_id")},
            inverseJoinColumns = {@JoinColumn(name = "destino_id")}
    )
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Destino> destinos = new ArrayList<Destino>();

}
