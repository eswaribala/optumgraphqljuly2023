package com.optum.customerapi.queries;

import com.optum.customerapi.dtos.FilterField;
import com.optum.customerapi.dtos.IndividualFilter;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.repositories.IndividualRepo;
import com.optum.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IndividualQuery implements GraphQLQueryResolver {

    @Autowired
    private IndividualService individualService;

    @Autowired
    private IndividualRepo individualRepo;

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

    public List<Individual> findIndividualWithFilter(IndividualFilter individualFilter){

        Specification<Individual> spec = null;
        if (individualFilter.getGender() != null)
            spec = byGender(individualFilter.getGender());

        if (spec != null)
            return individualRepo.findAll(spec);
        else
            return individualRepo.findAll();
    }


    private Specification<Individual> byGender(FilterField filterField) {
        return (Specification<Individual>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("gender"));
    }

}
