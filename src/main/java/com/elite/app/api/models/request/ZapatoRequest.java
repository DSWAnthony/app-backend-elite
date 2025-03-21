package com.elite.app.api.models.request;

import java.math.BigDecimal;

public record ZapatoRequest(
        ModeloRequest modelo,
        BigDecimal talla,
        String color,
        String sku,
        String urlImagen,
        BigDecimal precioComercial
) {
}
