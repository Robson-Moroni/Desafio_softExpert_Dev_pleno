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

           final BigDecimal descontoProporcional = conta.getDesconto().multiply(proporcaoPedido);
           final BigDecimal taxaEntregaProporcional = conta.getTaxaEntrega().multiply(proporcaoPedido);

           return pedido.getTotalPedido().subtract(descontoProporcional).add(taxaEntregaProporcional);
    }
}