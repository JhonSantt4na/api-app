package com.santt4na.rapidinner_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santt4na.rapidinner_delivery.model.identity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Long, Customer> {
}