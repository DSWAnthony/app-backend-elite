package com.elite.app.api.services;

import com.elite.app.api.entities.Categoria;
import com.elite.app.api.models.request.CategoriaRequest;

import java.util.List;

public interface CategoriaService {
    List<Categoria> getAll();
    Categoria getById(Integer id);
    Categoria save(CategoriaRequest categoria);
    Categoria update(Integer id, CategoriaRequest categoria);
    Boolean delete(int id);
}
