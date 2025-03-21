package com.elite.app.api.mappers;

import com.elite.app.api.entities.Inventario;
import com.elite.app.api.models.request.InventarioRequest;

public class InventarioMapper {
    public static Inventario toEntity(InventarioRequest inventario) {
        Inventario entity = new Inventario();
        entity.setCantidad_actual(inventario.cantidad_actual());
        entity.setStock_minimo(inventario.stock_minimo());
        entity.setStock_maximo(inventario.stock_maximo());

        return entity;
    }
}
