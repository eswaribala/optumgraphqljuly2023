package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepo extends JpaRepository<Individual,Long> {
}
