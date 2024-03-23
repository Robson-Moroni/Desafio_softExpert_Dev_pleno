package com.softexpert.divisaoconta.api;

import com.softexpert.divisaoconta.api.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.api.model.Conta;
import com.softexpert.divisaoconta.api.service.CalculadoraPedidoService;
import com.softexpert.divisaoconta.api.service.pagamento.PicpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"api/divisao-conta"})
public class DivisaoContaController {

    @Autowired
    private CalculadoraPedidoService calculadoraPedidoService;

    @Autowired
    private PicpayService picpayService;

    //TODO teste
    @PostMapping("/dividir")
    public List<DivisaoContaDTO> dividirConta(@RequestBody final Conta conta) {
        final List<DivisaoContaDTO> divisaoContaDTO = calculadoraPedidoService.calcularDivisaoConta(conta);
        return picpayService.adicionarLinkPagamento(divisaoContaDTO, conta.getDestinoPagamento()) ;
    }

}
