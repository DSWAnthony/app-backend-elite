package com.elite.app.api.models.response;

import com.elite.app.api.entities.Modelo;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
public class ZapatoModel {
    private Integer zapato_id;
    private Modelo modelo;
    private BigDecimal talla;
    private String color;
    private String sku;
    private String urlImagen;
    private BigDecimal precioComercial;
}
