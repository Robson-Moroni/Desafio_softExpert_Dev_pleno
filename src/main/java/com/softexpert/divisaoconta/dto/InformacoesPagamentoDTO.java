package com.softexpert.divisaoconta.dto;

import lombok.Data;

@Data
public class InformacoesPagamentoDTO<B extends Number, S> {
    final B valor;
    final S linkSimplificadoPagamento;
}
