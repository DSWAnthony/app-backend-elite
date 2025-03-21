package com.elite.app.api.mappers;

import com.elite.app.api.entities.Categoria;
import com.elite.app.api.models.request.CategoriaRequest;

public class CategoriaMapper {
    public static Categoria toEntity(CategoriaRequest categoria) {
        Categoria entity = new Categoria();
        entity.setNombre(categoria.nombre());
        return entity;
    }
}
