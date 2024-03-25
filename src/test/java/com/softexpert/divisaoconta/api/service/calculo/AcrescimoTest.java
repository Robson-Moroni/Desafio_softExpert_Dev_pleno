package com.softexpert.divisaoconta.api.service.calculo;

import com.softexpert.divisaoconta.api.model.OutroValor;
import com.softexpert.divisaoconta.api.service.calculo.Acrescimo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AcrescimoTest {

    @Test
    void deveAplicarAcrescimoEmReal() {

        final Acrescimo acrescimo = new Acrescimo();
        acrescimo.setTipo("REAL");
        acrescimo.setDescricao("Entrega do pedido");
        acrescimo.setValor(BigDecimal.TEN);

        final BigDecimal valorComAcrescimo = acrescimo.aplicar(BigDecimal.TEN, BigDecimal.valueOf(0.1));

        assertEquals(BigDecimal.valueOf(11.0), valorComAcrescimo);

    }
}
