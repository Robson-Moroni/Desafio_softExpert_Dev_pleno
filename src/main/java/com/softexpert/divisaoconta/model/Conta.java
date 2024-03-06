package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
public class Conta {

    private List<Pedido> listPedido;
    private BigDecimal taxaEntrega;
    private BigDecimal desconto;
    private BigDecimal acrescimo;

    public BigDecimal getTotal () {
        return this.listPedido.stream()
                .map(Pedido::getTotalPedido)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }


}
