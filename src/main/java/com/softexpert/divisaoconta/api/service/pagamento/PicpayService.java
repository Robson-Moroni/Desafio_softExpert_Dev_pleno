package com.softexpert.divisaoconta.api.service.pagamento;

import com.softexpert.divisaoconta.api.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.api.dto.InformacoesPagamentoDTO;
import com.softexpert.divisaoconta.api.service.pagamento.PagamentoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;

@Service
public class PicpayService implements PagamentoService<InformacoesPagamentoDTO> {

    //TODO teste
    public List<DivisaoContaDTO> adicionarLinkPagamento(final List<DivisaoContaDTO> divisaoContaDTOS,
                                                        final String destinoPagamento) {
        divisaoContaDTOS.forEach(divisaoContaDTO -> {
         final String linkPagamento = gerarLinkPagamento(divisaoContaDTO.getInformacoesPagamentoDTO());
         divisaoContaDTO.getInformacoesPagamentoDTO()
                 .adicionarDestinoPagamento(destinoPagamento)
                 .adicionarLinkSimplificadoPagamento(linkPagamento);
        });

        return divisaoContaDTOS;
    }

    //TODO teste
    @Override
    public String gerarLinkPagamento(final InformacoesPagamentoDTO informacoesPagamentoDTO) {
        final String destinoPagamento = informacoesPagamentoDTO.getDestinoPagamento();
        final BigDecimal valorAPagar = informacoesPagamentoDTO.getValorAPagar();

        return format("https://picpay.me/%s/%s", destinoPagamento , valorAPagar);
    }
}
