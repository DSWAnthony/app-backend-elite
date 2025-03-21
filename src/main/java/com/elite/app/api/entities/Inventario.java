package com.elite.app.api.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Inventario",
        uniqueConstraints = @UniqueConstraint(columnNames = {"zapato_id", "ubicacion_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventario_id;

    @ManyToOne
    @JoinColumn(name = "zapato_id", nullable = false)
    private Zapato zapato;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private UbicacionAlmacen ubicacion;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer cantidad_actual;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 10")
    private Integer stock_minimo;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 100")
    private Integer stock_maximo;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime ultima_actualizacion;
}
