package com.elite.app.api.controllers;

import com.elite.app.api.models.response.IngresosMensualesResp;
import com.elite.app.api.models.response.StockPorCategoria;
import com.elite.app.api.models.response.StockPorMarca;
import com.elite.app.api.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/dahsboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/total-inversion")
    public ResponseEntity<?> getTotalInversion() {
        long total = dashboardService.totalInversion();
        return ResponseEntity.ok(Collections.singletonMap("total", total));
    }

    @GetMapping("/total-proveedores")
    public ResponseEntity<?> getTotalProveedores() {
        long total = dashboardService.totalProveedores();

        return ResponseEntity.ok(Collections.singletonMap("total", total));
    }

    @GetMapping("/total-bajo-stock/{stock}")
    public ResponseEntity<?> getTotalBajoStock(@PathVariable int stock) {
        long total = dashboardService.totalBajoStock(stock);
        return ResponseEntity.ok(Collections.singletonMap("total", total));
    }

    @GetMapping("/total-zapatos")
    public ResponseEntity<?> getTotalzapatos() {
        long total = dashboardService.totalZapatos();
        return ResponseEntity.ok(Collections.singletonMap("total", total));
    }

    @GetMapping("/total-stock-marca")
    public ResponseEntity<List<StockPorMarca>> getTotalPorMarca() {
        return new ResponseEntity<>(dashboardService.totalStockPorMarca(), HttpStatus.OK);
    }
    @GetMapping("/total-stock-categoria")
    public ResponseEntity<List<StockPorCategoria>> getTotalPorCategoria() {
        return new ResponseEntity<>(dashboardService.totalStockPorCategoria(), HttpStatus.OK);
    }


    @GetMapping("/total-ingresos-ano/{ano}")
    public ResponseEntity<List<IngresosMensualesResp>> getIngresosDelAno(@PathVariable int ano) {
        return new ResponseEntity<>(dashboardService.obtenerIngresosDelAno(ano), HttpStatus.OK);
    }


}
