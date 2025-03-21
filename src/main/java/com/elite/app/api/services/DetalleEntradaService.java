package com.elite.app.api.services;

import com.elite.app.api.entities.DetalleEntrada;
import com.elite.app.api.models.request.DetalleEntradaRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DetalleEntradaService {
    List<DetalleEntrada> getAll();
    DetalleEntrada getById(Integer id);
    DetalleEntrada save(DetalleEntradaRequest detalleEntrada);
    DetalleEntrada update(Integer id, DetalleEntradaRequest detalleEntrada);
    Boolean delete(int id);
}
