package com.optum.customerapidgs.queries;

import com.optum.customerapidgs.dtos.FilterField;
import com.optum.customerapidgs.dtos.GenderFilterField;
import com.optum.customerapidgs.dtos.IndividualFilter;
import com.optum.customerapidgs.models.Individual;
import com.optum.customerapidgs.repositories.IndividualRepo;
import com.optum.customerapidgs.services.IndividualService;
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
        if (individualFilter.getCustomerId() != null)
            spec = byCustomerId(individualFilter.getCustomerId());
        if (individualFilter.getEmail() != null)
            spec = byEmail(individualFilter.getEmail());

        if (individualFilter.getGender()!= null)
            spec = byGender(individualFilter.getGender());
        if (spec != null)
            return individualRepo.findAll(spec);
        else
            return individualRepo.findAll();
    }


    private Specification<Individual> byCustomerId(FilterField filterField) {
        return (Specification<Individual>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("customerId"));
    }

    private Specification<Individual> byEmail(FilterField filterField) {
        return (Specification<Individual>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("email"));
    }


    private Specification<Individual> byGender(GenderFilterField filterField) {
        return (Specification<Individual>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("gender"));
    }
}
