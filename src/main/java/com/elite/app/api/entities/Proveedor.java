package com.elite.app.api.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Proveedor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proveedor_id;

    @Column(nullable = false)
    private String nombre;
    private String ruc;
    private String contacto;
    private String telefono;
    private String email;

    @Lob
    private String direccion;
}