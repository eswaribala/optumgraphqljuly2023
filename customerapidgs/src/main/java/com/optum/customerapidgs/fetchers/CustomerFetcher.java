package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.dtos.CustomerInput;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Customer;
import com.optum.customerapidgs.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class CustomerFetcher {

    @Autowired
    private CustomerRepo customerRepo;


    //queries
    @DgsQuery
    public List<Customer> findAllCustomers(){

        return this.customerRepo.findAll();
    }


    @DgsQuery
    public Customer findCustomerById(long customerId){

        Customer Customer=this.customerRepo.findById(customerId).orElse(null);
        if (Customer==null)
            throw new NoDataFoundError("Data Not Found","10001");
        else
            return Customer;
    }


    public Customer addCustomer(CustomerInput CustomerInput){

    }


}

