package com.prueba.tipocambio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftDataResponseDTO {

    private Double amount;
    private Double amountMoreType;
    private String originalCurrency;
    private String targetCurrency;
    private Double amountEnd;

}
