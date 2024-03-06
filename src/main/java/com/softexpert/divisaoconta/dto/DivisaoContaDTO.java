package com.softexpert.divisaoconta.dto;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class DivisaoContaDTO {
    private Map<String, Double> divisaoPorPessoa = new HashMap<>();

    public void adicionarDivisao(String descricao, double valor) {
        divisaoPorPessoa.put(descricao, valor);
    }
}
