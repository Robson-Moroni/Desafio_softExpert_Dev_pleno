package com.softexpert.divisaoconta.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Data
public class Pedido {
    private List<ItemPedido> itens;
    private String pessoa;
    private BigDecimal totalCalculado;

    public BigDecimal getTotalPedido() {
        return this.itens.stream()
                .map(ItemPedido::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    //TODO teste
    public Pedido aplicarDesconto(final Desconto desconto, final BigDecimal proporcaoPedido) {
        this.totalCalculado = desconto.aplicar(getTotalCalculado(), proporcaoPedido);
        return this;
    }

    //TODO teste
    public Pedido aplicarAcrescimo(final Acrescimo acrescimo, final BigDecimal proporcaoPedido) {
        this.totalCalculado = acrescimo.aplicar(getTotalCalculado(), proporcaoPedido);
        return this;
    }

    //TODO teste
    public BigDecimal getTotalCalculado() {
        return Optional.ofNullable(this.totalCalculado).orElse(getTotalPedido());
    }
}