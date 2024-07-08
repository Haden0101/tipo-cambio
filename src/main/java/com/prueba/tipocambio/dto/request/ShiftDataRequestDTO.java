package com.prueba.tipocambio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShiftDataRequestDTO {

    private Double amount;
    private String originalCurrency;
    private String targetCurrency;

}