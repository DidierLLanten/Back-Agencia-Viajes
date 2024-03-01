package com.eam.agencia.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="\"destino\"")
public class Destino {
    //Un destino puede estar en muchos paquetes turísticos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String imagen;
}
