package com.prueba.tipocambio.controller;

import com.prueba.tipocambio.dto.request.ShiftDataRequestDTO;
import com.prueba.tipocambio.dto.response.ShiftDataResponseDTO;
import com.prueba.tipocambio.service.ShiftDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shift")
public class ShiftDataController {

    @Autowired
    ShiftDataService shiftDataService;

    @PostMapping("/generate-exchange-rate")
    public Mono<ShiftDataResponseDTO> convert(@RequestBody ShiftDataRequestDTO shiftDataRequestDTO) {
        return shiftDataService.generatorExchangeRateService(shiftDataRequestDTO);
    }

}
