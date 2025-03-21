package com.elite.app.api.services.impl;

import com.elite.app.api.models.response.IngresosMensualesResp;
import com.elite.app.api.models.response.StockPorCategoria;
import com.elite.app.api.models.response.StockPorMarca;
import com.elite.app.api.repository.MarcaRepository;
import com.elite.app.api.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final MarcaRepository marcaRepository;

    @Override
    public List<StockPorMarca> totalStockPorMarca() {
        return marcaRepository.obtenerInventarioPorMarca();
    }

    @Override
    public List<StockPorCategoria> totalStockPorCategoria() {
        return marcaRepository.obtenerStockPorCategoria();
    }

    @Override
    public long totalZapatos() {
        return marcaRepository.obtenerTotalDeZapatillas();
    }

    @Override
    public long totalProveedores() {
        return marcaRepository.obtenerTotalDeProveedores();
    }

    @Override
    public long totalInversion() {
        return marcaRepository.obtenerTotalDeCompras();
    }

    @Override
    public long totalBajoStock(Integer stockMin) {
        return marcaRepository.obtenerTotalDeBajoStock(stockMin);
    }

    @Override
    public List<IngresosMensualesResp> obtenerIngresosDelAno(int ano) {

        List<Object[]> rows = marcaRepository.obtenerIngresosMensuales(ano);

        Map<String, Map<String, Integer>> datosPorMes = new LinkedHashMap<>();

        // 1. Inicializar todos los meses con ceros
        String[] meses = {"ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"};
        for (String mes : meses) {
            datosPorMes.put(mes, new HashMap<>());
        }

        // 2. Llenar datos reales
        for (Object[] fila : rows) {
            String mes = ((String) fila[0]).toLowerCase();  // Asegurar minúsculas
            String marca = (String) fila[1];
            Integer total = ((Number) fila[2]).intValue();

            datosPorMes.get(mes).put(marca, total);
        }

        return getIngresosMensualesResps(datosPorMes);
    }

    private static List<IngresosMensualesResp> getIngresosMensualesResps(Map<String, Map<String, Integer>> datosPorMes) {
        List<IngresosMensualesResp> datosFinales = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : datosPorMes.entrySet()) {
            IngresosMensualesResp dto = new IngresosMensualesResp();
            dto.setMes(entry.getKey());

            // Asegurar que todas las marcas tengan al menos 0
            Map<String, Integer> valores = entry.getValue();
            valores.putIfAbsent("Nike", 0);
            valores.putIfAbsent("Adidas", 0);

            dto.setMarcas(valores);
            datosFinales.add(dto);
        }
        return datosFinales;
    }
}
