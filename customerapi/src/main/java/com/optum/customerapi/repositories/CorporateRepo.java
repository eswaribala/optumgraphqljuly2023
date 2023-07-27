package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CorporateRepo extends JpaRepository<Corporate,Long>, JpaSpecificationExecutor<Corporate> {
}
