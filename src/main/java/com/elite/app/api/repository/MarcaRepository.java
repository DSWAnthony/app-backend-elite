package com.elite.app.api.repository;

import com.elite.app.api.entities.Marca;
import com.elite.app.api.models.response.IngresosMensualesResp;
import com.elite.app.api.models.response.StockPorCategoria;
import com.elite.app.api.models.response.StockPorMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    @Query(value = "{CALL ObtenerInventarioPorMarca()}",nativeQuery = true)
    List<StockPorMarca> obtenerInventarioPorMarca();

    @Query(value = "{CALL ObtenerTotalDeStockPorCategoria()}",nativeQuery = true)
    List<StockPorCategoria> obtenerStockPorCategoria();

    @Query(value = "{CALL TotalDeZapatillas()}",nativeQuery = true)
    Long obtenerTotalDeZapatillas();

    @Query(value = "{CALL TotalDeInversion()}",nativeQuery = true)
    Long obtenerTotalDeCompras();

    @Query(value = "{CALL TotalDeProveedores()}",nativeQuery = true)
    Long obtenerTotalDeProveedores();

    @Query(value = "{CALL TotalModeloBajoStock(:cantidad)}",nativeQuery = true)
    Long obtenerTotalDeBajoStock(@Param("cantidad") Integer cantidad);

    @Query(value = "{CALL IngresosMensuales(:anio)}",nativeQuery = true)
    List<Object[]> obtenerIngresosMensuales(@Param("anio") Integer anio);
}
