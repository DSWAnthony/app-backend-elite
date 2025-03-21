package com.elite.app.api.mappers;

import com.elite.app.api.entities.Proveedor;
import com.elite.app.api.models.request.ProveedorRequest;

public class ProveedorMapper {
    public static Proveedor toEntity(ProveedorRequest proveedor) {
        Proveedor entity = new Proveedor();
        entity.setContacto(proveedor.contacto());
        entity.setDireccion(proveedor.direccion());
        entity.setNombre(proveedor.nombre());
        entity.setEmail(proveedor.email());
        entity.setTelefono(proveedor.telefono());
        entity.setRuc(proveedor.ruc());
        return entity;
    }
}
