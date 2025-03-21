package com.elite.app.api.services;

import com.elite.app.api.entities.Marca;
import com.elite.app.api.models.request.MarcaRequest;

import java.util.List;

public interface MarcaService {
    List<Marca> getAll();
    Marca getById(Integer id);
    Marca save(MarcaRequest marca);
    Marca update(Integer id, MarcaRequest marca);
    Boolean delete(int id);
}
