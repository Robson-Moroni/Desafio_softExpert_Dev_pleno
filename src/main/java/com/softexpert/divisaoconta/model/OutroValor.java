package com.softexpert.divisaoconta.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OutroValor {
    private String tipo;
    private BigDecimal valor;
    private String descricao;
}
