package com.unicorn.repository;

import com.unicorn.entity.CreditCard;
import com.unicorn.entity.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
}
