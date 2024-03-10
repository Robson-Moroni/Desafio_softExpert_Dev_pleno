package com.softexpert.divisaoconta.api;

import com.softexpert.divisaoconta.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.model.Conta;
import com.softexpert.divisaoconta.model.Pedido;
import com.softexpert.divisaoconta.service.CalculadoraPedidoService;
import com.softexpert.divisaoconta.service.PicpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = {"api/divisao-conta"})
public class DivisaoContaController {

    @Autowired
    private CalculadoraPedidoService calculadoraPedidoService;

    @Autowired
    private PicpayService picpayService;

    @PostMapping("/dividir")
    public List<DivisaoContaDTO> dividirConta(@RequestBody final Conta conta) {
        final List<DivisaoContaDTO> divisaoContaDTO = calculadoraPedidoService.calcularDivisaoConta(conta);
        return picpayService.adicionarLinkPagamento(divisaoContaDTO, conta.getDestinoPagamento()) ;
    }

}
