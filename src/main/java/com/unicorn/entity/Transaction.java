package com.unicorn.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Entity
//@Data
public class Transaction {
    @Id
    @GeneratedValue
    private long transactionId;

    @ManyToOne
    @JoinColumn(name="fromCreditCard", nullable=false)
    @JsonIgnore
    private CreditCard fromCreditCard;

    @ManyToOne
    @JoinColumn(name="toCreditCard", nullable=false)
    @JsonIgnore
    private CreditCard toCreditCard;

    private long timestamp;

    private BigDecimal value;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final long transactionId) {
        this.transactionId = transactionId;
    }

    public CreditCard getFromCreditCard() {
        return fromCreditCard;
    }

    public void setFromCreditCard(final CreditCard fromCreditCard) {
        this.fromCreditCard = fromCreditCard;
    }

    public CreditCard getToCreditCard() {
        return toCreditCard;
    }

    public void setToCreditCard(final CreditCard toCreditCard) {
        this.toCreditCard = toCreditCard;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(final BigDecimal value) {
        this.value = value;
    }
}
