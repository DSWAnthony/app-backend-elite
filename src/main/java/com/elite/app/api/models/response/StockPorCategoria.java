package com.elite.app.api.models.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class StockPorCategoria {
    private String categoria;
    private BigDecimal total;
}
