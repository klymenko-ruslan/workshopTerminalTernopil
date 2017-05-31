package com.unicorn.repository;

import java.util.Collection;

import com.unicorn.entity.Transaction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@RepositoryRestResource
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
    Collection<Transaction> findByFromCreditCardCreditCardId(@Param("creditCardId") Long creditCardId);
}
