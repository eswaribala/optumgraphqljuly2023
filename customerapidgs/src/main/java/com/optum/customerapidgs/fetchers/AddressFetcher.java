package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.dtos.AddressInput;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Address;
import com.optum.customerapidgs.models.Customer;
import com.optum.customerapidgs.repositories.AddressRepo;
import com.optum.customerapidgs.repositories.CustomerRepo;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    return getAddress(addressInput,customerId);

}
   @DgsMutation
    public Address updateAddress(long customerId, AddressInput addressInput){
        return getAddress(addressInput,customerId);

    }

    /*@DgsData(parentType = "Address", field = "customer")
    public CompletableFuture<Customer> account(DataFetchingEnvironment dfe) {
        DataLoader<String,Customer> dataLoader = dfe.getDataLoader("customers");
        Address address = dfe.getSource();
        return dataLoader.load(address.getCustomer().getCustomerId());
    }*/
    @Nullable
    private Address getAddress(AddressInput addressInput,long customerId) {
        Customer customer=this.customerRepo.findById(customerId).orElse(null);

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
