package com.elite.app.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class InventarioResponse {
    private String sku;
    private String imagen;
    private String modelo;
    private BigDecimal talla;
    private String color;
    private String marca;
    private int stock;
    private String almacen;
}
