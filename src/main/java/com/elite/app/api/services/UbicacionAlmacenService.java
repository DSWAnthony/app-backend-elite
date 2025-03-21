package com.elite.app.api.services;

import com.elite.app.api.entities.UbicacionAlmacen;
import com.elite.app.api.models.request.UbicacionAlmacenRequest;

import java.util.List;

public interface UbicacionAlmacenService {
    List<UbicacionAlmacen> getAll();
    UbicacionAlmacen getById(Integer id);
    UbicacionAlmacen save(UbicacionAlmacenRequest ubicacionAlmacen);
    UbicacionAlmacen update(Integer id, UbicacionAlmacenRequest ubicacionAlmacen);
    Boolean delete(int id);
}
