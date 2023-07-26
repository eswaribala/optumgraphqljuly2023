package com.optum.customerapi.queries;

import com.optum.customerapi.models.Address;
import com.optum.customerapi.services.AddressService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressQuery implements GraphQLQueryResolver {

    @Autowired
    private AddressService addressService;

    public List<Address>  findAllAddresses(){
        return this.addressService.getAllAddresss();
    }
   public List<Address> findAddressById(long customerId){
        return this.addressService.getAddressById(customerId);
   }



}
