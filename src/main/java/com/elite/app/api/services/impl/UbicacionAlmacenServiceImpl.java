package com.elite.app.api.services.impl;

import com.elite.app.api.entities.UbicacionAlmacen;
import com.elite.app.api.mappers.UbicacionAlmacenMapper;
import com.elite.app.api.models.request.UbicacionAlmacenRequest;
import com.elite.app.api.repository.UbicacionAlmacenRepository;
import com.elite.app.api.services.UbicacionAlmacenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UbicacionAlmacenServiceImpl implements UbicacionAlmacenService {
    private final UbicacionAlmacenRepository repository;

    @Override
    public List<UbicacionAlmacen> getAll() {
        return repository.findAll();
    }

    @Override
    public UbicacionAlmacen getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UbicacionAlmacen no existe"));
    }

    @Override
    public UbicacionAlmacen save(UbicacionAlmacenRequest ubicacionAlmacen) {
        UbicacionAlmacen entity = UbicacionAlmacenMapper.toEntity(ubicacionAlmacen);
        return repository.save(entity);
    }

    @Override
    public UbicacionAlmacen update(Integer id, UbicacionAlmacenRequest ubicacionAlmacen) {
        return repository.findById(id)
                .map(UbicacionAlmacenEntity -> {
                    UbicacionAlmacen entity = UbicacionAlmacenMapper.toEntity(ubicacionAlmacen);
                    entity.setUbicacion_id(UbicacionAlmacenEntity.getUbicacion_id());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("UbicacionAlmacen No existe"));
    }

    @Override
    public Boolean delete(int id) {

        UbicacionAlmacen ubicacionAlmacen = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UbicacionAlmacen No existe"));

        if (ubicacionAlmacen != null){
            repository.delete(ubicacionAlmacen);
            return true;
        }

        return false;
    }
}
