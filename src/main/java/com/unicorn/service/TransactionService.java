package com.unicorn.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import com.unicorn.dto.TransactionDTO;
import com.unicorn.entity.Account;
import com.unicorn.entity.Transaction;
import com.unicorn.exception.InsufficientBalanceException;
import com.unicorn.repository.AccountRepository;
import com.unicorn.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public TransactionDTO executeTransaction(TransactionDTO transactionDTO) {
        Account accountFrom = getUpdatedAccountFrom(transactionDTO);
        Account accountTo = getUpdatedAccountTo(transactionDTO);
        createTransaction(accountFrom, accountTo, transactionDTO.getAmount());
        return transactionDTO;
    }

    private Account getUpdatedAccountFrom(TransactionDTO transactionDTO) {
        Account accountFrom = accountRepository.findOne(transactionDTO.getAccountFromId());
        BigDecimal sumAfterSubstraction = accountFrom.getBalance().subtract(transactionDTO.getAmount());
        if(sumAfterSubstraction.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Not enough " + sumAfterSubstraction.abs().toString());
        }
        accountFrom.setBalance(sumAfterSubstraction);
        return accountRepository.save(accountFrom);
    }
    private Account getUpdatedAccountTo(TransactionDTO transactionDTO) {
        Account accountTo = accountRepository.findOne(transactionDTO.getAccountToId());
        accountTo.setBalance(accountTo.getBalance().add(transactionDTO.getAmount()));
        return accountRepository.save(accountTo);
    }
    private void createTransaction(Account accountFrom, Account accountTo, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setFromAccount(accountFrom);
        transaction.setToAccount(accountTo);
        transaction.setTimestamp(System.currentTimeMillis());
        transaction.setValue(amount);

        transactionRepository.save(transaction);
    }
}
