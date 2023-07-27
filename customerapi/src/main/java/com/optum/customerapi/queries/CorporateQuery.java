package com.optum.customerapi.queries;

import com.optum.customerapi.dtos.CorporateFilter;
import com.optum.customerapi.dtos.FilterField;
import com.optum.customerapi.dtos.IndividualFilter;
import com.optum.customerapi.models.Corporate;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.repositories.CorporateRepo;
import com.optum.customerapi.services.CorporateService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorporateQuery implements GraphQLQueryResolver {

    @Autowired
    private CorporateService corporateService;

    @Autowired
    private CorporateRepo corporateRepo;

    public List<Corporate> findAllCorporates(){
        return this.corporateService.getAllCorporates();
    }
   public Corporate findCorporateById(long customerId){
        return this.corporateService.getCorporateById(customerId);
   }


    public List<Corporate> findCorporateByFirstName(String firstName){
        return this.corporateService.getCorporateByFirstName(firstName);
    }
    public List<Corporate> findCorporateWithFilter(CorporateFilter corporateFilter){

        Specification<Corporate> spec = null;
        if (corporateFilter.getCustomerId() != null)
            spec = byCompany(corporateFilter.getCustomerId());

        if (spec != null)
            return corporateRepo.findAll(spec);
        else
            return corporateRepo.findAll();
    }


    private Specification<Corporate> byCompany(FilterField filterField) {
        return (Specification<Corporate>) (root, query, builder) -> filterField.generateCriteria(builder, root.get("customerId"));
    }
}
