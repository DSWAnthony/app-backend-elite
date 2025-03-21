package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Marca;
import com.elite.app.api.mappers.MarcaMapper;
import com.elite.app.api.models.request.MarcaRequest;
import com.elite.app.api.repository.MarcaRepository;
import com.elite.app.api.services.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    @Override
    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca getById(Integer id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no Existe"));
    }

    @Override
    public Marca save(MarcaRequest marca) {
        Marca entity = MarcaMapper.toEntity(marca);
        return marcaRepository.save(entity);
    }

    @Override
    public Marca update(Integer id, MarcaRequest marca) {
        return marcaRepository.findById(id)
                .map(marcaEntity -> {
                    marcaEntity.setNombre(marca.nombre());
                    return marcaRepository.save(marcaEntity);
                })
                .orElseThrow(() -> new RuntimeException("Marca no Existe"));
    }

    @Override
    public Boolean delete(int id) {

        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no Existe"));

        if (marca != null){
            marcaRepository.delete(marca);
            return true;
        }

        return false;
    }
}
