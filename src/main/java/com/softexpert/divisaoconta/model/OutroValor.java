package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OutroValor {

    //TODO revisar essa logica
    private String tipoCobranca;
    private String tipoValor;

    private boolean isValorEmReal() {
        return "REAL".equals(this.tipoCobranca);
    }

    private boolean isValorEmPorcentagem() {
        return "PORCENTAGEM".equals(this.tipoCobranca);
    }

}
