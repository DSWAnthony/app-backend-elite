package com.elite.app.api.controllers;

import com.elite.app.api.entities.DetalleEntrada;
import com.elite.app.api.models.request.DetalleEntradaRequest;
import com.elite.app.api.services.DetalleEntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/ingreso/detalle")
@RequiredArgsConstructor
public class DetalleEntradaController {
    private final DetalleEntradaService detalleEntradaService;

    @GetMapping
    public List<DetalleEntrada> listarDetalleEntradas() {
        return detalleEntradaService.getAll();
    }

    @GetMapping("/{id}")
    public DetalleEntrada traerDetalleEntrada(@PathVariable Integer id) {
        return detalleEntradaService.getById(id);
    }

    @PostMapping
    public DetalleEntrada crearDetalleEntrada(
            @RequestBody DetalleEntradaRequest detalleEntrada
    ) {
        return detalleEntradaService.save(detalleEntrada);
    }

    @PutMapping("/{id}")
    public DetalleEntrada actualizarDetalleEntrada(
            @PathVariable Integer id, @RequestBody DetalleEntradaRequest detalleEntrada
    ) {
        return detalleEntradaService.update(id, detalleEntrada);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarDetalleEntrada(@PathVariable Integer id) {
        return detalleEntradaService.delete(id);
    }
}
