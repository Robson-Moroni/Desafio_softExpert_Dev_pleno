package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
public class Pedido {
    private List<ItemPedido> itens;
    private String pessoa;
    private BigDecimal total;

    public BigDecimal getTotalPedido() {
        return this.itens.stream()
                .map(ItemPedido::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }
}