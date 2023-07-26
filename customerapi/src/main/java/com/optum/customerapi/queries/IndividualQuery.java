package com.optum.customerapi.queries;

import com.optum.customerapi.models.Individual;
import com.optum.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IndividualQuery implements GraphQLQueryResolver {

    @Autowired
    private IndividualService individualService;

    public List<Individual> findAllIndividuals(){
        return this.individualService.getAllIndividuals();
    }
   public Individual findIndividualById(long customerId){
        return this.individualService.getIndividualById(customerId);
   }
    public List<Individual> findIndividualByContactNo(long contactNo){
        return this.individualService.getIndividualByContactNo(contactNo);
    }

    public List<Individual> findIndividualByFirstName(String firstName){
        return this.individualService.getIndividualByFirstName(firstName);
    }

}
