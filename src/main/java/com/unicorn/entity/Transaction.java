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
    @JoinColumn(name="fromAccount", nullable=false)
    @JsonIgnore
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name="toAccount", nullable=false)
    @JsonIgnore
    private Account toAccount;

    private long timestamp;

    private BigDecimal value;
}
