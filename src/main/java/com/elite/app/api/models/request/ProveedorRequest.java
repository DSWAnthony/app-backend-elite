package com.elite.app.api.models.request;

public record ProveedorRequest(
        String nombre,
        String contacto,
        String ruc,
        String telefono,
        String email,
        String direccion
) {
}
