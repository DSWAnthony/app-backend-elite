package com.elite.app.api.services.impl;

import com.elite.app.api.entities.Categoria;
import com.elite.app.api.entities.Marca;
import com.elite.app.api.entities.Modelo;
import com.elite.app.api.mappers.ModeloMapper;
import com.elite.app.api.models.request.CategoriaRequest;
import com.elite.app.api.models.request.MarcaRequest;
import com.elite.app.api.models.request.ModeloRequest;
import com.elite.app.api.repository.ModeloRepository;
import com.elite.app.api.services.CategoriaService;
import com.elite.app.api.services.MarcaService;
import com.elite.app.api.services.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl implements ModeloService {
    private final ModeloRepository modeloRepository;
    private final CategoriaService categoriaService;
    private final MarcaService marcaService;

    @Override
    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

    @Override
    public Modelo getById(Integer id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no Existe"));
    }

    @Override
    public Modelo save(ModeloRequest modelo) {
        Modelo entity = ModeloMapper.toEntity(modelo);

        if (modelo.categoria().id() !=null){
            actualizarCategoria(entity, modelo.categoria());
        }
        if (modelo.marca().id() != null){
            actualizarMarca(entity, modelo.marca());
        }

        return modeloRepository.save(entity);
    }

    @Override
    public Modelo update(Integer id, ModeloRequest modelo) {
        return modeloRepository.findById(id)
                .map(modeloEntity -> {
                    Modelo entity = ModeloMapper.toEntity(modelo);
                    entity.setModelo_id(modeloEntity.getModelo_id());

                    if (modelo.categoria().id() != null){
                        actualizarCategoria(modeloEntity, modelo.categoria());
                    }

                    if (modelo.marca().id() != null){
                        actualizarMarca(modeloEntity, modelo.marca());
                    }

                    return modeloRepository.save(modeloEntity);
                })
                .orElseThrow(() -> new RuntimeException("Modelo no Existe"));
    }

    @Override
    public Boolean delete(int id) {

        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no Existe"));

        if (modelo != null){
            modeloRepository.delete(modelo);
            return true;
        }

        return false;
    }


    private void actualizarCategoria(Modelo entity, CategoriaRequest categoria){
        if (categoria.id() !=null){
            Categoria categoriaEntity =  categoriaService.getById(categoria.id());
            entity.setCategoria(categoriaEntity);
        }
    }

    private void actualizarMarca(Modelo entity, MarcaRequest marca){
        if (marca.id() !=null){
            Marca marcaEntity =  marcaService.getById(marca.id());
            entity.setMarca(marcaEntity);
        }
    }


}
