package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OutroValor {

    //TODO revisar essa logica
    private String tipoCobranca;
    private String tipoValor;

    public boolean isValorEmReal() {
        return "REAL".equals(this.tipoValor);
    }

    public boolean isValorEmPorcentagem() {
        return "PORCENTAGEM".equals(this.tipoValor);
    }

    public boolean isDesconto() {return "DESCONTO".equals(this.tipoCobranca);}

    public boolean isAcrescimo() {return "ACRESCIMO".equals(this.tipoCobranca);}
}
