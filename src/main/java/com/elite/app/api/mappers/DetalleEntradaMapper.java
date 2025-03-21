package com.elite.app.api.mappers;

import com.elite.app.api.entities.DetalleEntrada;
import com.elite.app.api.models.request.DetalleEntradaRequest;

public class DetalleEntradaMapper {
    public static DetalleEntrada toEntity(DetalleEntradaRequest detalleEntrada) {
        DetalleEntrada entity = new DetalleEntrada();
        entity.setCantidad(detalleEntrada.cantidad());
        entity.setPrecioCompra(detalleEntrada.precio_compra());
        return entity;
    }
}
