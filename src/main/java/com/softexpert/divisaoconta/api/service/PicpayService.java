package com.softexpert.divisaoconta.api.service;

import com.softexpert.divisaoconta.api.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.api.dto.InformacoesPagamentoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class PicpayService implements PagamentoService<InformacoesPagamentoDTO> {

    public List<DivisaoContaDTO> adicionarLinkPagamento(final List<DivisaoContaDTO> divisaoContaDTOS,
                                                        final String destinoPagamento) {
        divisaoContaDTOS.forEach(divisaoContaDTO -> {

         divisaoContaDTO.getInformacoesPagamentoDTO()
                    .adicionarDestinoPagamento(destinoPagamento);

         final String linkPagamento = gerarLinkPagamento(divisaoContaDTO.getInformacoesPagamentoDTO());

         divisaoContaDTO.getInformacoesPagamentoDTO().adicionarLinkSimplificadoPagamento(linkPagamento);
        });

        return divisaoContaDTOS;

    }

    @Override
    public String gerarLinkPagamento(final InformacoesPagamentoDTO informacoesPagamentoDTO) {
        return format("https://picpay.me/%s/%s",
                informacoesPagamentoDTO.getDestinoPagamento() , informacoesPagamentoDTO.getValorAPagar());
    }
}
