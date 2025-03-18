package com.santt4na.rapidinner_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santt4na.rapidinner_delivery.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Long, Payment> {
}
