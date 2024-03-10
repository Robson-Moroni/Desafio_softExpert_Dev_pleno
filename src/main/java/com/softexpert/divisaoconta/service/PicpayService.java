package com.softexpert.divisaoconta.service;

import com.softexpert.divisaoconta.dto.DivisaoContaDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;

@Service
public class PicpayService {


    public List<DivisaoContaDTO> adicionarLinkPagamento(final List<DivisaoContaDTO> divisaoContaDTOS,
                                                        final String destinoPagamento) {
        divisaoContaDTOS.forEach(divisaoContaDTO -> {
            divisaoContaDTO.setLinkSimplificadoPagamento(gerarLinkPagamento(
                    divisaoContaDTO.getValorAPagar(),
                    destinoPagamento
            ));
        });

        return divisaoContaDTOS;

    }

    public String  gerarLinkPagamento(final BigDecimal valor, final String destinoPagamento) {
        return format("https://picpay.me/%s/%s", destinoPagamento , valor);
    }
}
