package com.prueba.tipocambio.service;

import com.prueba.tipocambio.dto.request.ShiftDataRequestDTO;
import com.prueba.tipocambio.dto.response.ShiftDataResponseDTO;
import com.prueba.tipocambio.feign.client.ExchangeRateClient;
import com.prueba.tipocambio.repository.ShiftDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ShiftDataService {

    @Autowired
    ShiftDataRepository shiftDataRepository;

    @Autowired
    ExchangeRateClient exchangeRateClient;

    public Mono<ShiftDataResponseDTO> generatorExchangeRateService (ShiftDataRequestDTO shiftDataRequestDTO){
        return exchangeRateClient.getLatestRates("USD").fla

    }


}
