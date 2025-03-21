package com.elite.app.api.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "DetalleEntrada")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DetalleEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalle_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "entrada_id", nullable = false)
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "zapato_id", nullable = false)
    private Zapato zapato;

    @Column(nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private UbicacionAlmacen ubicacion;

    @Column(name = "precio_compra", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCompra;
}
