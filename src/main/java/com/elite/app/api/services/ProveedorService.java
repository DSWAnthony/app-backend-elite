package com.elite.app.api.services;

import com.elite.app.api.entities.Proveedor;
import com.elite.app.api.models.request.ProveedorRequest;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> getAll();
    Proveedor getById(Integer id);
    Proveedor save(ProveedorRequest proveedor);
    Proveedor update(Integer id, ProveedorRequest proveedor);
    Boolean delete(int id);
}
