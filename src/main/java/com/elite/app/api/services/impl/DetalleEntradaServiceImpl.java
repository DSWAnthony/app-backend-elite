package com.elite.app.api.services.impl;

import com.elite.app.api.entities.*;
import com.elite.app.api.mappers.DetalleEntradaMapper;
import com.elite.app.api.models.request.DetalleEntradaRequest;
import com.elite.app.api.repository.DetalleEntradaRepository;
import com.elite.app.api.repository.InventarioRepository;
import com.elite.app.api.services.DetalleEntradaService;
import com.elite.app.api.services.EntradaService;
import com.elite.app.api.services.UbicacionAlmacenService;
import com.elite.app.api.services.ZapatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleEntradaServiceImpl implements DetalleEntradaService {
    private final DetalleEntradaRepository respository;
    private final ZapatoService zapatoService;
    private final EntradaService entradaService;
    private final UbicacionAlmacenService almacenService;
    private final InventarioRepository inventarioRepository;

    @Override
    public List<DetalleEntrada> getAll() {
        return respository.findAll();
    }

    @Override
    public DetalleEntrada getById(Integer id) {
        return respository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleEntrada no existe"));
    }

    @Override
    public DetalleEntrada save(DetalleEntradaRequest detalleEntrada) {
        DetalleEntrada entity = DetalleEntradaMapper.toEntity(detalleEntrada);

        Zapato zapato = zapatoService.save(detalleEntrada.zapato());

        UbicacionAlmacen almacen;
        if (detalleEntrada.almacen().almacen_id() !=null){
            almacen = almacenService.getById(detalleEntrada.almacen().almacen_id());
        }else {
            almacen = almacenService.save(detalleEntrada.almacen());
        }

        Entrada entrada;
        if (detalleEntrada.ingreso().ingreso_id() != null){
            entrada = entradaService.getById(detalleEntrada.ingreso().ingreso_id());
        }else {
            entrada = entradaService.save(detalleEntrada.ingreso());
        }

        Inventario inventario = Inventario.builder()
                .zapato(zapato)
                .ubicacion(almacen)
                .cantidad_actual(detalleEntrada.cantidad())
                .stock_minimo(4)
                .stock_maximo(50)
                .build();

        inventarioRepository.save(inventario);

        entity.setZapato(zapato);
        entity.setEntrada(entrada);
        entity.setUbicacion(almacen);

        return respository.save(entity);
    }

    @Override
    public DetalleEntrada update(Integer id, DetalleEntradaRequest detalleEntrada) {
        return respository.findById(id)
                .map(detalleEntradaEntity -> {
                    DetalleEntrada entity = DetalleEntradaMapper.toEntity(detalleEntrada);
                    entity.setDetalle_id(detalleEntradaEntity.getDetalle_id());
                    return respository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("DetalleEntradaRepository No existe"));
    }

    @Override
    public Boolean delete(int id) {

        DetalleEntrada detalleEntrada = respository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleEntradaRepository No existe"));

        if (detalleEntrada != null){
            respository.delete(detalleEntrada);
            return true;
        }

        return false;
    }
}
