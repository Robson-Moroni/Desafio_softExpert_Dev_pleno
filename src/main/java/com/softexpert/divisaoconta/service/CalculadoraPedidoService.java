package com.softexpert.divisaoconta.service;

import com.softexpert.divisaoconta.model.Conta;
import com.softexpert.divisaoconta.model.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculadoraPedidoService {

    public BigDecimal calcularTotalPagoPorItem(final Conta conta, Pedido pedido) {

           final BigDecimal proporcaoPedido = pedido.getTotalPedido().divide(
                   conta.getTotal(),2, RoundingMode.HALF_UP);

           final BigDecimal descontoProporcional = conta.getDesconto().getValor().multiply(proporcaoPedido);
           final BigDecimal acrescimoProporcional = conta.getAcrescimo().getValor().multiply(proporcaoPedido);

           return pedido.getTotalPedido().subtract(descontoProporcional).add(acrescimoProporcional);
    }
}