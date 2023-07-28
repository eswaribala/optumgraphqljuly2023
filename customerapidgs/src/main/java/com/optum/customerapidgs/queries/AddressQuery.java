package com.optum.customerapidgs.queries;

import com.optum.customerapidgs.models.Address;
import com.optum.customerapidgs.services.AddressService;
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
   public List<Address>   findAddressByIndividualCustomerId(long customerId){
        return this.addressService.getAddressByIndividualCustomerId(customerId);
   }

    public List<Address>   findAddressByCorporateCustomerId(long customerId){
        return this.addressService.getAddressByCorporateCustomerId(customerId);
    }


}
