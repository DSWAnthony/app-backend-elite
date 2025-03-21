package com.elite.app.api.models.request;

import com.elite.app.api.models.Genero;

public record ModeloRequest(
        Integer id,
        String nombre,
        Genero genero,
        MarcaRequest marca,
        CategoriaRequest categoria
) {
}
