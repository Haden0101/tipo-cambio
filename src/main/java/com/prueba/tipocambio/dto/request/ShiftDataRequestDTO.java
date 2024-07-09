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

    private double amount;
    private String sourceCurrency;
    private String targetCurrency;

}