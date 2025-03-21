package com.elite.app.api.services;

import com.elite.app.api.entities.Inventario;
import com.elite.app.api.models.request.InventarioRequest;
import com.elite.app.api.models.response.InventarioResponse;

import java.util.List;

public interface InventarioService {
    List<Inventario> getAll();
    Inventario getById(Integer id);
    Inventario save(InventarioRequest inventario);
    Inventario update(Integer id, InventarioRequest inventario);
    Boolean delete(int id);
    List<InventarioResponse> listarInventario();
}
