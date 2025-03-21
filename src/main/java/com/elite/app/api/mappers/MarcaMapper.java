package com.elite.app.api.mappers;

import com.elite.app.api.entities.Marca;
import com.elite.app.api.models.request.MarcaRequest;

public class MarcaMapper {
    public static Marca toEntity(MarcaRequest marca) {
        Marca entity = new Marca();
        entity.setNombre(marca.nombre());
        return entity;
    }
}
