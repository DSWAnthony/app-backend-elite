package com.elite.app.api.models.request;

public record InventarioRequest(
        int zapato_id,
        int ubicacion_id,
        int cantidad_actual,
        int stock_minimo,
        int stock_maximo

) {
}
