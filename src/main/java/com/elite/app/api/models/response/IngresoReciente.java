package com.elite.app.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class IngresoReciente {
    private String imagen;
    private BigDecimal talla;
    private BigDecimal precio;
    private String modelo;
    private String color;
    private BigDecimal stock_ingreso;
    private String fecha_ingreso;
}
