package com.unicorn.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private long userId;

    private String username;

    @OneToMany(mappedBy = "user")
    private Collection<CreditCard> creditCards;

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(final Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
