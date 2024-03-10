package com.softexpert.divisaoconta.api.service;

import com.softexpert.divisaoconta.api.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.api.model.Conta;
import com.softexpert.divisaoconta.api.model.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraPedidoService {

    public List<DivisaoContaDTO> calcularDivisaoConta(final Conta conta) {
        List<DivisaoContaDTO> listDivisaoContaDTO = new ArrayList<>();
        conta.getPedidos().forEach(pedido -> {
            final BigDecimal totalPago = calcularTotalPagoPorItem(conta, pedido);
            listDivisaoContaDTO.add(DivisaoContaDTO.of(
                    pedido.getPessoa(),
                    totalPago));
        });

        return listDivisaoContaDTO;
    }

    public BigDecimal calcularTotalPagoPorItem(final Conta conta, final Pedido pedido) {

           final BigDecimal proporcaoPedido = pedido.getTotalPedido().divide(
                   conta.getTotal(),2, RoundingMode.HALF_UP);

        return pedido
                .aplicarDesconto(conta.getDesconto(), proporcaoPedido)
                .aplicarAcrescimo(conta.getAcrescimo(), proporcaoPedido).getTotalCalculado();
    }
}