package com.elite.app.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UbicacionAlmacen",
        uniqueConstraints = @UniqueConstraint(columnNames = {"pasillo", "estante", "contenedor"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UbicacionAlmacen
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ubicacion_id;

    @Column(nullable = false)
    private String pasillo;

    @Column(nullable = false)
    private String estante;

    @Column(nullable = false)
    private String contenedor;
}
