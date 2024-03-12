package com.softexpert.divisaoconta.service;

import com.softexpert.divisaoconta.api.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.api.model.Conta;
import com.softexpert.divisaoconta.api.model.ItemPedido;
import com.softexpert.divisaoconta.api.model.OutroValor;
import com.softexpert.divisaoconta.api.model.Pedido;
import com.softexpert.divisaoconta.api.service.CalculadoraPedidoService;
import com.softexpert.divisaoconta.api.service.PicpayService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisaoContaTest {

    private CalculadoraPedidoService service = new CalculadoraPedidoService();

    private PicpayService servicePagamento = new PicpayService();

    @Test
    void calcularTotalPagoPorItem() {

        Conta conta = new Conta();

        Pedido pedido = new Pedido();
        pedido.setItens(
                List.of(
                        new ItemPedido("Hamburguer", BigDecimal.valueOf(40.00), 1L),
                        new ItemPedido("sobremesa", BigDecimal.valueOf(2.00), 1L)));


       Pedido pedido1 = new Pedido();
       pedido1.setItens(List.of(new ItemPedido("sanduiche", BigDecimal.valueOf(8.00), 1L)));

        conta.setPedidos(List.of(pedido,pedido1));

        final OutroValor desconto = new OutroValor("REAL", BigDecimal.valueOf(20.0), "DESCONTO");
        final OutroValor acrescimo = new OutroValor("REAL", BigDecimal.valueOf(8.0), "ACRESCIMO");

       conta.setOutrosValores(List.of(desconto,acrescimo));

        BigDecimal totalPagoAmigo1 = service.calcularTotalPagoPorItem(conta, pedido);
        BigDecimal totalPagoAmigo2 = service.calcularTotalPagoPorItem(conta, pedido1);

        assertEquals(BigDecimal.valueOf(31.92), totalPagoAmigo1.setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.valueOf(6.08), totalPagoAmigo2.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void calcularTotalPagoPorItemDescontoEmPorcentagem() {

        Conta conta = new Conta();

        Pedido pedido = new Pedido();
        pedido.setItens(
                List.of(
                        new ItemPedido("Hamburguer", BigDecimal.valueOf(40.00), 1L),
                        new ItemPedido("sobremesa", BigDecimal.valueOf(2.00), 1L)));


        Pedido pedido1 = new Pedido();
        pedido1.setItens(List.of(new ItemPedido("sanduiche", BigDecimal.valueOf(8.00), 1L)));

        conta.setPedidos(List.of(pedido,pedido1));

        final OutroValor desconto = new OutroValor("PORCENTAGEM", BigDecimal.valueOf(40.0), "DESCONTO");
        final OutroValor acrescimo = new OutroValor("REAL", BigDecimal.valueOf(8.0), "ACRESCIMO");

        conta.setOutrosValores(List.of(desconto,acrescimo));

        BigDecimal totalPagoAmigo1 = service.calcularTotalPagoPorItem(conta, pedido);
        BigDecimal totalPagoAmigo2 = service.calcularTotalPagoPorItem(conta, pedido1);

        assertEquals(BigDecimal.valueOf(31.92), totalPagoAmigo1.setScale(2, RoundingMode.HALF_UP));
        assertEquals(BigDecimal.valueOf(6.08), totalPagoAmigo2.setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void deveGerarLinkSimplificadoEAdicionarAoRetorno() {

        Conta conta = new Conta();

        Pedido pedido = new Pedido();
        pedido.setItens(
                List.of(
                        new ItemPedido("Hamburguer", BigDecimal.valueOf(40.00), 1L),
                        new ItemPedido("sobremesa", BigDecimal.valueOf(2.00), 1L)));


        Pedido pedido1 = new Pedido();
        pedido1.setItens(List.of(new ItemPedido("sanduiche", BigDecimal.valueOf(8.00), 1L)));

        conta.setPedidos(List.of(pedido,pedido1));

        final OutroValor desconto = new OutroValor("PORCENTAGEM", BigDecimal.valueOf(40.0), "DESCONTO");
        final OutroValor acrescimo = new OutroValor("REAL", BigDecimal.valueOf(8.0), "ACRESCIMO");

        conta.setOutrosValores(List.of(desconto,acrescimo));

        List<DivisaoContaDTO> divisaoContaDTOS = service.calcularDivisaoConta(conta);

        List<DivisaoContaDTO> divisaoContaComInformaçõesPagamento = servicePagamento.adicionarLinkPagamento(
                divisaoContaDTOS, "@robsonmoroni");

    }
}
