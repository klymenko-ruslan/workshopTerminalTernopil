package com.unicorn.dto;

import java.math.BigDecimal;

//import lombok.Data;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
//@Data
public class TransactionDTO {
    private long creditCardFromId;
    private long creditCardToId;
    private String creditCardPassword;
    private BigDecimal amount;

    public long getCreditCardFromId() {
        return creditCardFromId;
    }

    public void setCreditCardFromId(final long creditCardFromId) {
        this.creditCardFromId = creditCardFromId;
    }

    public long getCreditCardToId() {
        return creditCardToId;
    }

    public void setCreditCardToId(final long creditCardToId) {
        this.creditCardToId = creditCardToId;
    }

    public String getCreditCardPassword() {
        return creditCardPassword;
    }

    public void setCreditCardPassword(final String creditCardPassword) {
        this.creditCardPassword = creditCardPassword;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }
}
