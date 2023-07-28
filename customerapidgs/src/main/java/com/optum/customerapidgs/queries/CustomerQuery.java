package com.optum.customerapidgs.queries;

import com.optum.customerapidgs.models.Customer;
import com.optum.customerapidgs.repositories.CustomerRepo;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerQuery implements GraphQLQueryResolver {

    @Autowired
    private CustomerRepo customerRepo;


    public Customer searchCustomer(long customerId){
        return this.customerRepo.findById(customerId).orElse(null);
    }

}
