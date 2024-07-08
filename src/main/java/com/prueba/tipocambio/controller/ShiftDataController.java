package com.prueba.tipocambio.controller;

import com.prueba.tipocambio.dto.request.ShiftDataRequestDTO;
import com.prueba.tipocambio.dto.response.ShiftDataResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shift")
public class ShiftDataController {

    @PostMapping("/generate-exchange-rate")
    public Mono<ShiftDataResponseDTO> generatorExchangeRate(@RequestBody ShiftDataRequestDTO shiftDataRequestDTO) {
        return null;
    }

}
