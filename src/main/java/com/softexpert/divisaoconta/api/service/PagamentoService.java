package com.softexpert.divisaoconta.api.service;

public interface PagamentoService<T> {

     String gerarLinkPagamento(T informacoesPagamentoDTO);
}
