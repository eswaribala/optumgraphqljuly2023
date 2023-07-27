package com.optum.customerapi.repositories;

import com.optum.customerapi.models.Individual;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndividualRepo extends JpaRepository<Individual,Long>, JpaSpecificationExecutor<Individual> {
    @Query("Select i from Individual i where i.contactNo=:contactNo")
    public List<Individual> findByContactNo(@Param("contactNo") long contactNo);


}
