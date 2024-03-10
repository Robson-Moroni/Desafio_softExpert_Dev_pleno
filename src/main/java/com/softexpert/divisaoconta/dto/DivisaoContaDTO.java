package com.softexpert.divisaoconta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class DivisaoContaDTO {
    private String nomeDonoPedido;
    private BigDecimal valorAPagar;
    private String linkSimplificadoPagamento;

    public DivisaoContaDTO(final String nomeDonoPedido, final BigDecimal valorAPagar) {
        this.nomeDonoPedido = nomeDonoPedido;
        this.valorAPagar = valorAPagar;
    }

    public static DivisaoContaDTO of(
            final String nomeDonoPedido,
            final BigDecimal valorAPagar){

        return new DivisaoContaDTO(nomeDonoPedido,valorAPagar);
    }
}
