package com.unicorn.repository;

import com.unicorn.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
