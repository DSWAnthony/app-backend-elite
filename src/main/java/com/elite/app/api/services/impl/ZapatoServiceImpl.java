package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Modelo;
import com.elite.app.api.entities.Zapato;
import com.elite.app.api.mappers.ModeloMapper;
import com.elite.app.api.mappers.ZapatoMapper;
import com.elite.app.api.models.request.ZapatoRequest;
import com.elite.app.api.repository.ZapatoRepository;
import com.elite.app.api.services.ModeloService;
import com.elite.app.api.services.ZapatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZapatoServiceImpl implements ZapatoService {
    
    private final ZapatoRepository zapatoRepository;
    private final ModeloService modeloService;

    @Override
    public List<Zapato> getAll() {
        return zapatoRepository.findAll();
    }

    @Override
    public Zapato getById(Integer id) {
        return zapatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zapato no Existe"));
    }

    @Override
    public Zapato save(ZapatoRequest zapato) {
        Zapato entity = ZapatoMapper.toEntity(zapato);

        Modelo modelo;
        if (zapato.modelo().id() != null){
            modelo = modeloService.getById(zapato.modelo().id());
        }else {
            modelo = modeloService.save(zapato.modelo());
        }
        entity.setModelo(modelo);
        return zapatoRepository.save(entity);
    }

    @Override
    public Zapato update(Integer id, ZapatoRequest zapato) {
        return zapatoRepository.findById(id)
                .map(zapatoEntity -> {

                    Zapato entity = ZapatoMapper.toEntity(zapato);

                    if (zapato.modelo().id() != null) {
                        Modelo modeloActualizado = modeloService.update(zapato.modelo().id(), zapato.modelo());
                        entity.setModelo(modeloActualizado);
                    } else {
                        entity.setModelo(ModeloMapper.toEntity(zapato.modelo()));
                    }


                    entity.setZapato_id(zapatoEntity.getZapato_id());

                    return zapatoRepository.save(entity);
                })
                .orElseThrow(() -> new RuntimeException("Zapato no Existe"));
    }

    @Override
    public Boolean delete(int id) {

        Zapato zapato = zapatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zapato no Existe"));

        if (zapato != null){
            zapatoRepository.delete(zapato);
            return true;
        }

        return false;
    }

}
