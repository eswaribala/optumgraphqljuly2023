package com.optum.customerapidgs.mutations;

import com.optum.customerapidgs.dtos.AddressInput;
import com.optum.customerapidgs.models.Address;
import com.optum.customerapidgs.services.AddressService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMutation implements GraphQLMutationResolver {

    @Autowired
    private AddressService addressService;

    public Address addIndividualAddress(AddressInput addressInput,long customerId){

        Address address=Address.builder()
                .addressId(addressInput.getAddressId())
                .city(addressInput.getCity())
                .doorNo(addressInput.getDoorNo())
                .streetName(addressInput.getStreetName())
                .pincode(addressInput.getPincode())

                .build();

       return this.addressService.addIndividualAddress(address,customerId);

    }
    public Address addCorporateAddress(AddressInput addressInput,long customerId){

        Address address=Address.builder()
                .addressId(addressInput.getAddressId())
                .city(addressInput.getCity())
                .doorNo(addressInput.getDoorNo())
                .streetName(addressInput.getStreetName())
                .pincode(addressInput.getPincode())

                .build();

        return this.addressService.addCorporateAddress(address,customerId);

    }
    public Address updateIndividualAddress(long customerId,AddressInput addressInput){
        Address address=Address.builder()
                .addressId(addressInput.getAddressId())
                .city(addressInput.getCity())
                .doorNo(addressInput.getDoorNo())
                .streetName(addressInput.getStreetName())
                .pincode(addressInput.getPincode())

                .build();

        return this.addressService.updateIndividualAddress(address,customerId);
    }
    public Address updateCorporateAddress(long customerId,AddressInput addressInput){
        Address address=Address.builder()
                .addressId(addressInput.getAddressId())
                .city(addressInput.getCity())
                .doorNo(addressInput.getDoorNo())
                .streetName(addressInput.getStreetName())
                .pincode(addressInput.getPincode())

                .build();

        return this.addressService.updateCorporateAddress(address,customerId);
    }
    public boolean deleteAddress(long addressId){

        return this.addressService.deleteAddress(addressId);
    }
}
