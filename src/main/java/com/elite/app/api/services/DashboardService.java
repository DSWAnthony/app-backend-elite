package com.elite.app.api.services;

import com.elite.app.api.models.response.IngresosMensualesResp;
import com.elite.app.api.models.response.StockPorCategoria;
import com.elite.app.api.models.response.StockPorMarca;

import java.util.List;

public interface DashboardService {

    List<StockPorMarca> totalStockPorMarca();
    List<StockPorCategoria> totalStockPorCategoria();
    long totalZapatos();
    long totalProveedores();
    long totalInversion();
    long totalBajoStock(Integer stockMin);
    List<IngresosMensualesResp> obtenerIngresosDelAno(int ano);

}
