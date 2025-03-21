package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Inventario;
import com.elite.app.api.entities.UbicacionAlmacen;
import com.elite.app.api.entities.Zapato;
import com.elite.app.api.mappers.InventarioMapper;
import com.elite.app.api.models.request.InventarioRequest;
import com.elite.app.api.models.response.InventarioResponse;
import com.elite.app.api.repository.InventarioRepository;
import com.elite.app.api.services.InventarioService;
import com.elite.app.api.services.UbicacionAlmacenService;
import com.elite.app.api.services.ZapatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioServiceImpl implements InventarioService {
    private final InventarioRepository inventarioRepository;
    private final ZapatoService zapatoService;
    private final UbicacionAlmacenService almacenService;
    
    @Override
    public List<Inventario> getAll() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario getById(Integer id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no existe"));
    }

    @Override
    public Inventario save(InventarioRequest inventario) {
        Inventario entity = InventarioMapper.toEntity(inventario);

        Zapato zapato = zapatoService.getById(inventario.zapato_id());
        UbicacionAlmacen almacen = almacenService.getById(inventario.ubicacion_id());

        entity.setZapato(zapato);
        entity.setUbicacion(almacen);

        return inventarioRepository.save(entity);
    }

    @Override
    public Inventario update(Integer id, InventarioRequest inventario) {
        return inventarioRepository.findById(id)
                .map(inventarioEntity -> {
                    Inventario entity = InventarioMapper.toEntity(inventario);
                    entity.setInventario_id(inventarioEntity.getInventario_id());
                    return inventarioRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Inventario No existe"));
    }

    @Override
    public Boolean delete(int id) {

        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario No existe"));

        if (inventario != null){
            inventarioRepository.delete(inventario);
            return true;
        }

        return false;
    }

    @Override
    public List<InventarioResponse> listarInventario() {
        return inventarioRepository.listarInventario();
    }
}
