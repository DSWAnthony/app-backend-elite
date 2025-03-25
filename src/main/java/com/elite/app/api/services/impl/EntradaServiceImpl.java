package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Entrada;
import com.elite.app.api.entities.Proveedor;
import com.elite.app.api.mappers.EntradaMapper;
import com.elite.app.api.models.request.EntradaRequest;
import com.elite.app.api.repository.EntradaRepository;
import com.elite.app.api.services.EntradaService;
import com.elite.app.api.services.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntradaServiceImpl implements EntradaService {
    private final EntradaRepository entradaRepository;
    private final ProveedorService proveedorService;

    @Override
    public List<Entrada> getAll() {
        return entradaRepository.findAll();
    }

    @Override
    public Entrada getById(Integer id) {
        return entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada no existe"));
    }

    @Override
    public Entrada save(EntradaRequest entrada) {
        Entrada entity = EntradaMapper.toEntity(entrada);

        Proveedor proveedor = proveedorService.getById(entrada.proveedor_id());

        entity.setProveedor(proveedor);
        return entradaRepository.save(entity);
    }

    @Override
    public Entrada update(Integer id, EntradaRequest entrada) {
        return entradaRepository.findById(id)
                .map(entradaEntity -> {
                    Entrada entity = EntradaMapper.toEntity(entrada);

                    if (entrada.proveedor_id() !=null){
                       Proveedor proveedor = proveedorService.getById(entrada.proveedor_id());
                       entity.setProveedor(proveedor);
                    }
                    entity.setEntrada_id(entradaEntity.getEntrada_id());
                    return entradaRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Entrada No existe"));
    }

    @Override
    public Boolean delete(int id) {

        Entrada entrada = entradaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrada No existe"));

        if (entrada != null){
            entradaRepository.delete(entrada);
            return true;
        }

        return false;
    }
}
