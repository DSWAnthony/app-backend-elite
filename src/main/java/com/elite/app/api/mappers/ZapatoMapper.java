package com.elite.app.api.mappers;

import com.elite.app.api.entities.Zapato;
import com.elite.app.api.models.request.ZapatoRequest;

public class ZapatoMapper {

    public static Zapato toEntity(ZapatoRequest zapato) {
        Zapato entity = new Zapato();
        entity.setColor(zapato.color());
        if (zapato.modelo().id() == null) entity.setModelo(ModeloMapper.toEntity(zapato.modelo()));
        if (zapato.sku() != null) entity.setSku(zapato.sku());
        entity.setTalla(zapato.talla());
        entity.setUrlImagen(zapato.urlImagen());
        entity.setPrecioComercial(zapato.precioComercial());

        return entity;
    }
}
