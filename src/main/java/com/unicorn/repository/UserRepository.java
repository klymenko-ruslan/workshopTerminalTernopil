package com.unicorn.repository;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import com.unicorn.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
