package com.elite.app.api.mappers;

import com.elite.app.api.entities.Modelo;
import com.elite.app.api.models.request.ModeloRequest;

public class ModeloMapper {

    public static Modelo toEntity(ModeloRequest modelo) {
        Modelo entity = new Modelo();
        entity.setNombre(modelo.nombre());
        if (modelo.categoria().id() == null) entity.setCategoria(CategoriaMapper.toEntity(modelo.categoria()));
        entity.setGenero(modelo.genero());
        if (modelo.marca().id() == null) entity.setMarca(MarcaMapper.toEntity(modelo.marca()));
        return entity;
    }
}
