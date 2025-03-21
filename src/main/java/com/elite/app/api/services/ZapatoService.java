package com.elite.app.api.services;

import com.elite.app.api.entities.Zapato;
import com.elite.app.api.models.request.ZapatoRequest;

import java.util.List;

public interface ZapatoService {
    List<Zapato> getAll();
    Zapato getById(Integer id);
    Zapato save(ZapatoRequest zapato);
    Zapato update(Integer id, ZapatoRequest zapato);
    Boolean delete(int id);
}
