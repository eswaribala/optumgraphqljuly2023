package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Individual;
import com.optum.customerapidgs.repositories.IndividualRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class IndividualFetcher {

    @Autowired
    private IndividualRepo individualRepo;


    //queries
    @DgsQuery
    public List<Individual> findAllIndividuals(){

        return this.individualRepo.findAll();
    }


    @DgsQuery
    public Individual findIndividualById(long customerId){

        Individual individual=this.individualRepo.findById(customerId).orElse(null);
        if (individual==null)
            throw new NoDataFoundError("Data Not Found","10001");
        else
            return individual;
    }
}

