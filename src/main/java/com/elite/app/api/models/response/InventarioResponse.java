package com.elite.app.api.models.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
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
