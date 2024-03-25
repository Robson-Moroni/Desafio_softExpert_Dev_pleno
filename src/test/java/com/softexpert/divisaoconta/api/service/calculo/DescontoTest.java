package com.softexpert.divisaoconta.api.service.calculo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DescontoTest {

    @Test
    void deveAplicaDescontoEmReal() {

        final Desconto desconto = new Desconto();
        desconto.setTipo("REAL");
        desconto.setDescricao("Entrega do pedido");
        desconto.setValor(BigDecimal.TEN);

        final BigDecimal valorComAcrescimo = desconto.aplicar(BigDecimal.TEN, BigDecimal.valueOf(0.1));

        assertEquals(BigDecimal.valueOf(9.0), valorComAcrescimo);

    }
}
