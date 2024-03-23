package com.softexpert.divisaoconta.api.service.calculo;

import com.softexpert.divisaoconta.api.model.OutroValor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Desconto extends OutroValor {

    public BigDecimal aplicar(final BigDecimal valorTotalPedido, final BigDecimal proporcionalidade){
        return valorTotalPedido.subtract(this.getValorProporcional(proporcionalidade));
    }
}
