package com.prueba.tipocambio.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "exchangeRateClient", url = "https://v6.exchangerate-api.com/v6/851b5739a61120d5b9ae51e0")
public interface ExchangeRateClient {

    @GetMapping("/latest/{currency}")
    Map<String, Object> getLatestRates(@PathVariable("currency") String currency);
}
