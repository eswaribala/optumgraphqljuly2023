package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.dtos.AddressInput;
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


    public Address  addAddress(AddressInput addressInput, long customerId){

    }

    public Address updateAddress(long customerId, AddressInput addressInput){


    }

    @DgsMutation
    public boolean deleteAddress(long addressId){
        boolean status=false;
        this.addressRepo.deleteById(addressId);
        Address address=this.addressRepo.findById(addressId).orElse(null);
        if(address==null)
          status=true;
        return status;
    }

}
