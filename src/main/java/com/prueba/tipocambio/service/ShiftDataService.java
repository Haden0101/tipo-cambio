package com.prueba.tipocambio.service;

import com.prueba.tipocambio.domain.ShiftData;
import com.prueba.tipocambio.dto.request.ShiftDataRequestDTO;
import com.prueba.tipocambio.dto.response.ShiftDataResponseDTO;
import com.prueba.tipocambio.feign.client.ExchangeRateClient;
import com.prueba.tipocambio.feign.dto.ExchangeRateResponse;
import com.prueba.tipocambio.repository.ShiftDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ShiftDataService {

    @Autowired
    ShiftDataRepository shiftDataRepository;

    @Autowired(required = false)
    ExchangeRateClient exchangeRateClient;

    public Mono<ShiftDataResponseDTO> generatorExchangeRateService(ShiftDataRequestDTO shiftDataRequestDTO) {
        return Mono.fromCallable(() -> {
            ExchangeRateResponse response = exchangeRateClient.getExchangeRates(shiftDataRequestDTO.getSourceCurrency());
            Double rate = response.getConversion_rates().get(shiftDataRequestDTO.getTargetCurrency());
            if (rate == null) {
                throw new IllegalArgumentException("Currency not supported: " + shiftDataRequestDTO.getTargetCurrency());
            }

            double convertedAmount = shiftDataRequestDTO.getAmount() * rate;
            ShiftDataResponseDTO responseDTO = new ShiftDataResponseDTO();
            responseDTO.setAmount(shiftDataRequestDTO.getAmount());
            responseDTO.setConvertedAmount(convertedAmount);
            responseDTO.setSourceCurrency(shiftDataRequestDTO.getSourceCurrency());
            responseDTO.setTargetCurrency(shiftDataRequestDTO.getTargetCurrency());
            responseDTO.setExchangeRate(rate);

            ShiftData transaction = new ShiftData();
            transaction.setAmount(shiftDataRequestDTO.getAmount());
            transaction.setConvertedAmount(convertedAmount);
            transaction.setSourceCurrency(shiftDataRequestDTO.getSourceCurrency());
            transaction.setTargetCurrency(shiftDataRequestDTO.getTargetCurrency());
            transaction.setExchangeRate(rate);
            shiftDataRepository.save(transaction);

            return responseDTO;
        });
    }


}
