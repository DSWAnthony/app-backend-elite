package com.elite.app.api.services;

import com.elite.app.api.entities.Modelo;
import com.elite.app.api.models.request.ModeloRequest;

import java.util.List;

public interface ModeloService {
    List<Modelo> getAll();
    Modelo getById(Integer id);
    Modelo save(ModeloRequest modelo);
    Modelo update(Integer id, ModeloRequest modelo);
    Boolean delete(int id);
}
