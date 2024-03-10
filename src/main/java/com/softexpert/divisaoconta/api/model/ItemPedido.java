package com.softexpert.divisaoconta.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
    private String descricao;
    private BigDecimal valor;
    private Long quantidade;
}
