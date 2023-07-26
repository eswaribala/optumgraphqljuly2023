package com.optum.customerapi.queries;

import com.optum.customerapi.models.Corporate;
import com.optum.customerapi.services.CorporateService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CorporateQuery implements GraphQLQueryResolver {

    @Autowired
    private CorporateService corporateService;

    public List<Corporate> findAllCorporates(){
        return this.corporateService.getAllCorporates();
    }
   public Corporate findCorporateById(long customerId){
        return this.corporateService.getCorporateById(customerId);
   }


    public List<Corporate> findCorporateByFirstName(String firstName){
        return this.corporateService.getCorporateByFirstName(firstName);
    }

}
