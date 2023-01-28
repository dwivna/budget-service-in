package com.aws.instance.budget.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aws.instance.budget.entity.PersonEntity;

@EnableScan

public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, String> {

}
