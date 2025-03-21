package com.elite.app.api.models.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class IngresosMensualesResp {
    private String mes;
    private Map<String, Integer> marcas;
}
