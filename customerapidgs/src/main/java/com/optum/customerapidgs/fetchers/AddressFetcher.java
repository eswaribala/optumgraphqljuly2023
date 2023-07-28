package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Address;
import com.optum.customerapidgs.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class AddressFetcher {
    @Autowired
    private AddressRepo addressRepo;

    @DgsQuery
    public List<Address> findAllAddresses(){
           return this.addressRepo.findAll();
    }

    @DgsQuery
    public List<Address> findAddressByCustomerId(long customerId){

        List<Address> addresses=this.addressRepo.findByCustomerId(customerId);
        if(addresses.size()==0)
            throw new NoDataFoundError("Data Not Found","1002");
        else
            return addresses;


    }

}
