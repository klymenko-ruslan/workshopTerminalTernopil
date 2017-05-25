package com.unicorn.entity;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Entity
@Data
public class CreditCard {

    @Id
    @GeneratedValue
    private long creditCardId;

    private String password;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @OneToMany(mappedBy = "fromCreditCard")
    private Collection<Transaction> fromTransactions;

    @OneToMany(mappedBy = "toCreditCard")
    private Collection<Transaction> toTransactions;

    private BigDecimal balance;

}
