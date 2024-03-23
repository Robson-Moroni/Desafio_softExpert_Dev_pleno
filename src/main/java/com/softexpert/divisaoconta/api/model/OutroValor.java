package com.softexpert.divisaoconta.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutroValor {
    //TODO avaliar uso de enum
    protected String tipo;
    protected BigDecimal valor;
    protected String descricao;

    public BigDecimal getValorProporcional(final BigDecimal proporcionalidade) {
        return this.getValor().multiply(proporcionalidade);
    }

    public BigDecimal getValorEmReal(final BigDecimal totalConta) {
        if (tipo.equals("PORCENTAGEM")) {
           return totalConta.multiply(this.valor.divide(BigDecimal.valueOf(100L)));
        }

        return this.valor;
    }
}
