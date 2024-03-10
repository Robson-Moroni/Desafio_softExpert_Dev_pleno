package com.softexpert.divisaoconta.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DivisaoContaDTO {
    private String nomeDonoPedido;
    private InformacoesPagamentoDTO informacoesPagamentoDTO;

    public DivisaoContaDTO(final String nomeDonoPedido,
                           final InformacoesPagamentoDTO informacoesPagamentoDTO) {
        this.nomeDonoPedido = nomeDonoPedido;
        this.informacoesPagamentoDTO = informacoesPagamentoDTO;
    }

    public static DivisaoContaDTO of(
            final String nomeDonoPedido,
            final BigDecimal valorAPagar){

        return new DivisaoContaDTO(nomeDonoPedido, InformacoesPagamentoDTO.of(valorAPagar));
    }
}
