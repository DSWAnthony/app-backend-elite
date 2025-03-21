package com.elite.app.api.controllers;

import com.elite.app.api.entities.UbicacionAlmacen;
import com.elite.app.api.models.request.UbicacionAlmacenRequest;
import com.elite.app.api.services.UbicacionAlmacenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacen")
@RequiredArgsConstructor
public class AlmacenController {
    private final UbicacionAlmacenService almacenService;

    @GetMapping
    public List<UbicacionAlmacen> listarUbicacionAlmacens() {
        return almacenService.getAll();
    }

    @GetMapping("/{id}")
    public UbicacionAlmacen traerUbicacionAlmacen(@PathVariable Integer id) {
        return almacenService.getById(id);
    }

    @PostMapping
    public UbicacionAlmacen crearUbicacionAlmacen(
            @RequestBody UbicacionAlmacenRequest almacen
    ) {
        return almacenService.save(almacen);
    }

    @PutMapping("/{id}")
    public UbicacionAlmacen actualizarUbicacionAlmacen(
            @PathVariable Integer id, @RequestBody UbicacionAlmacenRequest almacen
    ) {
        return almacenService.update(id, almacen);
    }

    @DeleteMapping("/{id}")
    public Boolean actualizarUbicacionAlmacen(@PathVariable Integer id) {
        return almacenService.delete(id);
    }
}
