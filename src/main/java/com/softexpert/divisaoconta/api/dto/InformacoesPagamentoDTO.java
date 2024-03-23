package com.softexpert.divisaoconta.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class InformacoesPagamentoDTO {
    private String destinoPagamento;
    private BigDecimal valorAPagar;
    private String linkSimplificadoPagamento;


    public static InformacoesPagamentoDTO of (final BigDecimal valorAPagar) {
        final InformacoesPagamentoDTO informacoesPagamentoDTO = new InformacoesPagamentoDTO();

        informacoesPagamentoDTO.setValorAPagar(valorAPagar);

        return informacoesPagamentoDTO;
    }

    //TODO talvez teste validar se adiciona como builder
    public InformacoesPagamentoDTO adicionarLinkSimplificadoPagamento(final String link) {
        this.linkSimplificadoPagamento = link;
        return this;
    }

    //TODO talvez teste, e validar se adiciona como builder
    public InformacoesPagamentoDTO adicionarDestinoPagamento(final String destinoPagamento) {
        this.destinoPagamento = destinoPagamento;
        return this;
    }

}
