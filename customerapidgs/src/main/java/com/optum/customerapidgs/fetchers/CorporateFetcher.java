package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Corporate;
import com.optum.customerapidgs.repositories.CorporateRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class CorporateFetcher {
    
    @Autowired
    private CorporateRepo corporateRepo;

    //queries
    @DgsQuery
    public List<Corporate> findAllCorporates(){

        return this.corporateRepo.findAll();
    }


    @DgsQuery
    public Corporate findCorporateById(long customerId){

        Corporate Corporate=this.corporateRepo.findById(customerId).orElse(null);
        if (Corporate==null)
            throw new NoDataFoundError("Data Not Found","10001");
        else
            return Corporate;
    }
    
}
