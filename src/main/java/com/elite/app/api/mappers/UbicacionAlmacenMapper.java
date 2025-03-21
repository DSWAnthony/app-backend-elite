package com.elite.app.api.mappers;

import com.elite.app.api.entities.UbicacionAlmacen;
import com.elite.app.api.models.request.UbicacionAlmacenRequest;

public class UbicacionAlmacenMapper {
    public static UbicacionAlmacen toEntity(UbicacionAlmacenRequest ubicacionAlmacen) {
        UbicacionAlmacen almacen = new UbicacionAlmacen();
        almacen.setContenedor(ubicacionAlmacen.contenedor());
        almacen.setEstante(ubicacionAlmacen.estante());
        almacen.setPasillo(ubicacionAlmacen.pasillo());

        return almacen;
    }
}
