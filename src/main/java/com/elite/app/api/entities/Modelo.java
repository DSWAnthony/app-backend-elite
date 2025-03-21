package com.elite.app.api.entities;

import com.elite.app.api.models.Genero;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Modelo")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer modelo_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}

