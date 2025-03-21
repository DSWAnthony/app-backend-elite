package com.elite.app.api.mappers;

import com.elite.app.api.entities.Entrada;
import com.elite.app.api.models.request.EntradaRequest;

public class EntradaMapper {
    public static Entrada toEntity(EntradaRequest entrada) {
        Entrada entity = new Entrada();
        entity.setOrdenCompra(entrada.orden_compra());
        entity.setFecha_entrada(entrada.fecha_ingreso());
        return entity;
    }
}
