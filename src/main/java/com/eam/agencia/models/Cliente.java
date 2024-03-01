package com.eam.agencia.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="\"cliente\"")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @Column(nullable = false, unique = true)
    private String identificacion;
    private String email;
}
