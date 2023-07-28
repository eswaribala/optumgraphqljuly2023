package com.optum.customerapidgs.repositories;

import com.optum.customerapidgs.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
