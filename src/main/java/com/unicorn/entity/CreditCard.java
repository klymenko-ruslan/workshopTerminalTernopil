package com.unicorn.entity;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Entity
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

    public long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(final long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Collection<Transaction> getFromTransactions() {
        return fromTransactions;
    }

    public void setFromTransactions(final Collection<Transaction> fromTransactions) {
        this.fromTransactions = fromTransactions;
    }

    public Collection<Transaction> getToTransactions() {
        return toTransactions;
    }

    public void setToTransactions(final Collection<Transaction> toTransactions) {
        this.toTransactions = toTransactions;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }
}
