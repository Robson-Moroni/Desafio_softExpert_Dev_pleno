package com.softexpert.divisaoconta.api;

import com.softexpert.divisaoconta.dto.DivisaoContaDTO;
import com.softexpert.divisaoconta.model.Conta;
import com.softexpert.divisaoconta.model.Pedido;
import com.softexpert.divisaoconta.service.CalculadoraPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"api/divisaoConta"})
public class DivisaoContaController {

    @Autowired
    private CalculadoraPedidoService calculadoraPedidoService;

//    @PostMapping("/dividir")
//    public DivisaoContaDTO dividirConta(@RequestBody Conta conta) {
//        DivisaoContaDTO divisaoContaDTO = new DivisaoContaDTO();
//        pedido.getItens().forEach(item -> {
//            double totalPago = calculadoraPedidoService.calcularTotalPagoPorItem(pedido, item);
//            divisaoContaDTO.adicionarDivisao(item.getDescricao(), totalPago);
//        });
//        return divisaoContaDTO;
//    }
}
