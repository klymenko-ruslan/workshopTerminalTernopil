package com.unicorn.repository.interceptor;

import com.unicorn.entity.CreditCard;
import com.unicorn.entity.User;
import com.unicorn.repository.CreditCardRepository;
import com.unicorn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Component
@RepositoryEventHandler(CreditCard.class)
public class CreditCardEventHandler {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @HandleBeforeCreate
    public void handleUserCreate(CreditCard creditCard) {
        creditCard.setPassword(passwordEncoder.encode(creditCard.getPassword()));
    }

    @HandleBeforeSave
    public void handleUserUpdate(CreditCard creditCard) {
        if (creditCard.getPassword() == null || creditCard.getPassword().equals("")) {
            CreditCard storedCreditCard = creditCardRepository.findOne(creditCard.getCreditCardId());
            creditCard.setPassword(storedCreditCard.getPassword());
        } else {
            creditCard.setPassword(passwordEncoder.encode(creditCard.getPassword()));
        }
    }
}