package com.prueba.tipocambio.feign.client;

import com.prueba.tipocambio.feign.dto.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "exchangeRateClient", url = "https://v6.exchangerate-api.com")
public interface ExchangeRateClient {

    @GetMapping("/v6/851b5739a61120d5b9ae51e0/latest/{baseCurrency}")
    ExchangeRateResponse getExchangeRates(@RequestParam("baseCurrency") String baseCurrency);
}