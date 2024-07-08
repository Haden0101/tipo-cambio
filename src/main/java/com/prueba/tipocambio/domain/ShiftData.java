package com.prueba.tipocambio.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class ShiftData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double amount;
    private String targetCurrency;
    private String originalCurrency;
    private Double exchangeRate;

}
