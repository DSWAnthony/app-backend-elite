package com.elite.app.api.repository;

import com.elite.app.api.entities.Inventario;
import com.elite.app.api.models.response.InventarioResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    @Query(value = "SELECT * FROM ListarInventario",nativeQuery = true)
    List<InventarioResponse> listarInventario();
}
