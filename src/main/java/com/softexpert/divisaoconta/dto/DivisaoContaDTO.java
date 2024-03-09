package com.softexpert.divisaoconta.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class DivisaoContaDTO {
    private Map<String, BigDecimal> divisaoPorPessoa = new HashMap<>();

    public void adicionarDivisao(final String pessoa, final BigDecimal valor) {
        divisaoPorPessoa.put(pessoa, valor);
    }
}
