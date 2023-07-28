package com.optum.customerapidgs.repositories;

import com.optum.customerapidgs.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address,Long> {

    @Query("Select a from Address a where a.individual.customerId=:customerId")
    public List<Address> findByIndividualCustomerId(@Param("customerId") long customerId);
    @Query("Select a from Address a where a.corporate.customerId=:customerId")
    public List<Address> findByCorporateCustomerId(@Param("customerId") long customerId);
}
