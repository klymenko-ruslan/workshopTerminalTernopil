package com.unicorn.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import com.unicorn.dto.TransactionDTO;
import com.unicorn.entity.CreditCard;
import com.unicorn.entity.Transaction;
import com.unicorn.exception.InsufficientBalanceException;
import com.unicorn.exception.NoSuchCreditCardException;
import com.unicorn.exception.WrongAuthoritiesException;
import com.unicorn.repository.CreditCardRepository;
import com.unicorn.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Service
public class TransactionService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public TransactionDTO executeTransaction(TransactionDTO transactionDTO) {
        CreditCard creditCardFrom = getUpdatedCreditCardFrom(transactionDTO);
        CreditCard creditCardTo = getUpdatedCreditCardTo(transactionDTO);
        createTransaction(creditCardFrom, creditCardTo, transactionDTO.getAmount());
        return transactionDTO;
    }

    private CreditCard getUpdatedCreditCardFrom(TransactionDTO transactionDTO) {
        CreditCard creditCardFrom = creditCardRepository.findOne(transactionDTO.getCreditCardFromId());
        if(creditCardFrom == null) {
            throw new NoSuchCreditCardException("There's no such credit card with id " + transactionDTO.getCreditCardFromId());
        }
        if(!passwordEncoder.matches(transactionDTO.getCreditCardPassword(), creditCardFrom.getPassword())) {
            throw new WrongAuthoritiesException("Credit card password is invalid");
        }
        BigDecimal sumAfterSubstraction = creditCardFrom.getBalance().subtract(transactionDTO.getAmount());
        if(sumAfterSubstraction.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Not enough " + sumAfterSubstraction.abs().toString());
        }
        creditCardFrom.setBalance(sumAfterSubstraction);
        return creditCardRepository.save(creditCardFrom);
    }
    private CreditCard getUpdatedCreditCardTo(TransactionDTO transactionDTO) {
        CreditCard creditCardTo = creditCardRepository.findOne(transactionDTO.getCreditCardToId());
        if(creditCardTo == null) {
            throw new NoSuchCreditCardException("There's no such credit card with id " + transactionDTO.getCreditCardToId());
        }
        creditCardTo.setBalance(creditCardTo.getBalance().add(transactionDTO.getAmount()));
        return creditCardRepository.save(creditCardTo);
    }
    private void createTransaction(CreditCard creditCardFrom, CreditCard creditCardTo, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setFromCreditCard(creditCardFrom);
        transaction.setToCreditCard(creditCardTo);
        transaction.setTimestamp(System.currentTimeMillis());
        transaction.setValue(amount);

        transactionRepository.save(transaction);
    }
}
