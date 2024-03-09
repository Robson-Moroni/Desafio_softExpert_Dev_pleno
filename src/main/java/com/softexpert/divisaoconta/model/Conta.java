package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
public class Conta {

    private List<Pedido> pedidos;
    private Desconto desconto;
    private Acrescimo acrescimo;
    private BigDecimal total;

    public BigDecimal getTotal () {
        return this.pedidos.stream()
                .map(Pedido::getTotalPedido)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }


}
