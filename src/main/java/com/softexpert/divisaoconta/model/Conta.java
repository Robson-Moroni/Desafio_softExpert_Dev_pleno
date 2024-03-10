package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
public class Conta {

    private List<Pedido> pedidos;
    private List<OutroValor> outrosValores;
    private BigDecimal total;

    public BigDecimal getTotal () {
        return this.pedidos.stream()
                .map(Pedido::getTotalPedido)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public Desconto getDesconto() {
        final Desconto desconto = new Desconto();
        desconto.setValor(getTotalOutrosValoresPorTipo("DESCONTO"));
        return desconto;
    }

    public Acrescimo getAcrescimo() {
        final Acrescimo acrescimo = new Acrescimo();
        acrescimo.setValor(getTotalOutrosValoresPorTipo("ACRESCIMO"));
        return acrescimo;
    }

    private BigDecimal getTotalOutrosValoresPorTipo(final String tipoOutrosValores) {
        return outrosValores.stream()
                .filter(outroValor -> outroValor.getDescricao().equals(tipoOutrosValores))
                .map(outroValor -> outroValor.getValorEmReal(getTotal()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
