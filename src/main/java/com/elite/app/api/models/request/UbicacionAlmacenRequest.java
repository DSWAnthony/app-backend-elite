package com.elite.app.api.models.request;

public record UbicacionAlmacenRequest(
        Integer almacen_id,
        String pasillo,
        String estante,
        String contenedor
) {
}
