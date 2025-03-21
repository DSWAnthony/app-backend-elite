package com.elite.app.api.models.request;

import java.math.BigDecimal;

public record DetalleEntradaRequest(
        EntradaRequest ingreso,
        ZapatoRequest zapato,
        UbicacionAlmacenRequest almacen,
        int cantidad,
        BigDecimal precio_compra
) {
}