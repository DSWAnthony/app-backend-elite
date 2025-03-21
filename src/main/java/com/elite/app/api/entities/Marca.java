package com.elite.app.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Marca")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marca_id;

    @Column(nullable = false, unique = true)
    private String nombre;
}

