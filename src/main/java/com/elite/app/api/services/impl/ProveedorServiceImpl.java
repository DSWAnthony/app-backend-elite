package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Proveedor;
import com.elite.app.api.mappers.ProveedorMapper;
import com.elite.app.api.models.request.ProveedorRequest;
import com.elite.app.api.repository.ProveedorRepository;
import com.elite.app.api.services.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
    private final ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getById(Integer id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no existe"));
    }

    @Override
    public Proveedor save(ProveedorRequest proveedor) {
        Proveedor entity = ProveedorMapper.toEntity(proveedor);
        return proveedorRepository.save(entity);
    }

    @Override
    public Proveedor update(Integer id, ProveedorRequest proveedor) {
        return proveedorRepository.findById(id)
                .map(proveedorEntity -> {
                    Proveedor entity = ProveedorMapper.toEntity(proveedor);
                    entity.setProveedor_id(proveedorEntity.getProveedor_id());
                    return proveedorRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Proveedor No existe"));
    }

    @Override
    public Boolean delete(int id) {

        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor No existe"));

        if (proveedor != null){
            proveedorRepository.delete(proveedor);
            return true;
        }

        return false;
    }
}
