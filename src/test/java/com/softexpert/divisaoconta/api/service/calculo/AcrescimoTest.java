package com.softexpert.divisaoconta.api.service.calculo;

import com.softexpert.divisaoconta.api.model.OutroValor;
import com.softexpert.divisaoconta.api.service.calculo.Acrescimo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AcrescimoTest {

    @Test
    void deveAplicarAcrescimoEmReal() {

        final OutroValor outroValor = new OutroValor();
        outroValor.setTipo("REAL");
        outroValor.setDescricao("Entrega do pedido");
        outroValor.setValor(BigDecimal.TEN);

        final Acrescimo acrescimo = (Acrescimo) outroValor;

        BigDecimal valorComAcrescimo = acrescimo.aplicar(BigDecimal.TEN, BigDecimal.ONE);

        assertEquals(BigDecimal.valueOf(11L), valorComAcrescimo);

    }
}
