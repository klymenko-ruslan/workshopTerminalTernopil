package com.unicorn.controller;

import com.unicorn.dto.TransactionDTO;
import com.unicorn.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public TransactionDTO transaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.executeTransaction(transactionDTO);
    }
}
