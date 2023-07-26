package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
