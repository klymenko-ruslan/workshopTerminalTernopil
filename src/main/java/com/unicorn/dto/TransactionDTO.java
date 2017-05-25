package com.unicorn.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Data
public class TransactionDTO {
    private long creditCardFromId;
    private long creditCardToId;
    private String creditCardPassword;
    private BigDecimal amount;
}
