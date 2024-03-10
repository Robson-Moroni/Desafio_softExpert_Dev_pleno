package com.softexpert.divisaoconta.api;

import com.softexpert.divisaoconta.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.model.Conta;
import com.softexpert.divisaoconta.model.Pedido;
import com.softexpert.divisaoconta.service.CalculadoraPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = {"api/divisao-conta"})
public class DivisaoContaController {

    @Autowired
    private CalculadoraPedidoService calculadoraPedidoService;

    @PostMapping("/dividir")
    public DivisaoContaDTO dividirConta(@RequestBody final Conta conta) {
        return calculadoraPedidoService.calcularDivisaoConta(conta);
    }

}
