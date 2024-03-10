package com.softexpert.divisaoconta.service;

import com.softexpert.divisaoconta.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.model.Conta;
import com.softexpert.divisaoconta.model.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculadoraPedidoService {

    public DivisaoContaDTO calcularDivisaoConta(final Conta conta) {
        DivisaoContaDTO divisaoContaDTO = new DivisaoContaDTO();
        conta.getPedidos().forEach(pedido -> {
            final BigDecimal totalPago = calcularTotalPagoPorItem(conta, pedido);
            divisaoContaDTO.adicionarDivisao(pedido.getPessoa(), totalPago);
        });

        return divisaoContaDTO;
    }

    public BigDecimal calcularTotalPagoPorItem(final Conta conta, final Pedido pedido) {

           final BigDecimal proporcaoPedido = pedido.getTotalPedido().divide(
                   conta.getTotal(),2, RoundingMode.HALF_UP);

        return pedido
                .aplicarDesconto(conta.getDesconto(), proporcaoPedido)
                .aplicarAcrescimo(conta.getAcrescimo(), proporcaoPedido).getTotalCalculado();
    }
}