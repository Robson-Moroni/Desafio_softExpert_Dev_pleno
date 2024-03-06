package com.softexpert.divisaoconta.service;

import com.softexpert.divisaoconta.model.Conta;
import com.softexpert.divisaoconta.model.ItemPedido;
import com.softexpert.divisaoconta.model.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisaoContaTest {

    private CalculadoraPedidoService service = new CalculadoraPedidoService();

    @Test
    void calcularTotalPagoPorItem() {

        Conta conta = new Conta();

        Pedido pedido = new Pedido();
        pedido.setItens(
                List.of(
                        new ItemPedido("Hamburguer", BigDecimal.valueOf(40.00)),
                        new ItemPedido("sobremesa", BigDecimal.valueOf(2.00))));


       Pedido pedido1 = new Pedido();
       pedido1.setItens(List.of(new ItemPedido("sanduiche", BigDecimal.valueOf(8.00))));

        conta.setListPedido(List.of(pedido,pedido1));
        conta.setTaxaEntrega(BigDecimal.valueOf(8.0));
        conta.setDesconto(BigDecimal.valueOf(20.0));

        BigDecimal totalPagoAmigo1 = service.calcularTotalPagoPorItem(conta, pedido);
        BigDecimal totalPagoAmigo2 = service.calcularTotalPagoPorItem(conta, pedido1);

        assertEquals(BigDecimal.valueOf(31.92), totalPagoAmigo1.setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.valueOf(6.08), totalPagoAmigo2.setScale(2, RoundingMode.HALF_UP));
    }
}