package com.elite.app.api.models.request;

import java.time.LocalDate;
public record EntradaRequest(
        Integer id,
        Integer proveedor_id,
        LocalDate fecha_ingreso,
        String orden_compra
) {
}
