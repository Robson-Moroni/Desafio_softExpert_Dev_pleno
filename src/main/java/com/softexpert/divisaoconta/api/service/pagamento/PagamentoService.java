package com.softexpert.divisaoconta.api.service.pagamento;

public interface PagamentoService<T> {

     String gerarLinkPagamento(T informacoesPagamentoDTO);
}
