package com.unicorn.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private long userId;

    private String username;

   // private boolean enabled;

    @OneToMany(mappedBy = "user")
    private Collection<CreditCard> creditCards;
}
