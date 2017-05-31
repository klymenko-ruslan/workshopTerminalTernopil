package com.unicorn.repository;

import com.unicorn.entity.CreditCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@RepositoryRestResource
public interface CreditCardRepository extends PagingAndSortingRepository<CreditCard, Long> {
}
