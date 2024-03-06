package com.softexpert.divisaoconta.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PicpayService {
    public String gerarLinkPagamento(BigDecimal valor) {
        // Implementar a lógica para gerar o link do Picpay
        // Exemplo: https://app.picpay.com/user/transaction?value=valor
        return "https://app.picpay.com/user/transaction?value=" + valor;
    }
}
