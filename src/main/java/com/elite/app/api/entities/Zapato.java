package com.elite.app.api.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Zapato",
        uniqueConstraints = @UniqueConstraint(columnNames = {"modelo_id", "talla", "color"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Zapato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zapato_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @Column(nullable = false, precision = 3, scale = 1)
    private BigDecimal talla;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(name = "url_imagen", nullable = false)
    private String urlImagen;

    @Column(name = "precio_comercial", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioComercial;
}
