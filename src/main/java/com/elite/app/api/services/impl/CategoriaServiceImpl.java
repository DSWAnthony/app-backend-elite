package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Categoria;
import com.elite.app.api.mappers.CategoriaMapper;
import com.elite.app.api.models.request.CategoriaRequest;
import com.elite.app.api.repository.CategoriaRepository;
import com.elite.app.api.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAll() {
        return  categoriaRepository.findAll();
    }

    @Override
    public Categoria getById(Integer id) {
        return categoriaRepository.findById(id).
                orElseThrow();
    }

    @Override
    public Categoria save(CategoriaRequest categoria) {
        Categoria entity = CategoriaMapper.toEntity(categoria);
        return categoriaRepository.save(entity);
    }

    @Override
    public Categoria update(Integer id, CategoriaRequest categoria) {

        return categoriaRepository.findById(id)
                .map(categoriaEntity -> {
                    categoriaEntity.setNombre(categoria.nombre());
                    return categoriaRepository.save(categoriaEntity);
                })
                .orElseThrow();
    }

    @Override
    public Boolean delete(int id) {

        var categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        if (categoria.getCategoria_id() == id) {
            categoriaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
