package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateRepo extends JpaRepository<Corporate,Long> {
}
