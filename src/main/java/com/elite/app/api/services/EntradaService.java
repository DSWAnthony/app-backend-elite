package com.elite.app.api.services;

import com.elite.app.api.entities.Entrada;
import com.elite.app.api.models.request.EntradaRequest;

import java.util.List;

public interface EntradaService {
    List<Entrada> getAll();
    Entrada getById(Integer id);
    Entrada save(EntradaRequest entrada);
    Entrada update(Integer id, EntradaRequest entrada);
    Boolean delete(int id);
}
