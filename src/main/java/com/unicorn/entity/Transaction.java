package com.unicorn.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Entity
@Data
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
}
