package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Acrescimo extends OutroValor {

    public BigDecimal aplicar(final BigDecimal valorTotalPedido, final BigDecimal proporcionalidade){
        return valorTotalPedido.add(this.getValorProporcional(proporcionalidade));
    }
}
