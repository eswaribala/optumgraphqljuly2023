package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.dtos.AddressInput;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Address;
import com.optum.customerapidgs.models.Customer;
import com.optum.customerapidgs.repositories.AddressRepo;
import com.optum.customerapidgs.repositories.CustomerRepo;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class AddressFetcher {
    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private CustomerRepo customerRepo;

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

@DgsMutation
    public Address  addAddress(AddressInput addressInput, long customerId){
    return getAddress(addressInput);

}

    public Address updateAddress(long customerId, AddressInput addressInput){
        return getAddress(addressInput);

    }

    @Nullable
    private Address getAddress(AddressInput addressInput) {
        Customer customer=this.customerRepo.findById(addressInput.getCustomer().getCustomerId()).orElse(null);

        if(customer!=null) {
            Address address = Address.builder()
                    .addressId(addressInput.getAddressId())
                    .city(addressInput.getCity())
                    .doorNo(addressInput.getDoorNo())
                    .streetName(addressInput.getStreetName())
                    .pincode(addressInput.getPincode())
                    .customer(customer)
                    .build();
            return this.addressRepo.save(address);
        }else {
            return null;
        }
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
