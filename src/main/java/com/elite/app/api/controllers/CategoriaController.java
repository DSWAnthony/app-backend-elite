package com.elite.app.api.controllers;

import com.elite.app.api.entities.Categoria;
import com.elite.app.api.models.request.CategoriaRequest;
import com.elite.app.api.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public Categoria traerCategoria(@PathVariable Integer id) {
        return categoriaService.getById(id);
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody CategoriaRequest categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaRequest categoria) {
        return categoriaService.update(id,
                categoria);
    }

    @DeleteMapping("/{id}")
    public Boolean eliminarCategoria(@PathVariable Integer id) {
        return categoriaService.delete(id);
    }
}
