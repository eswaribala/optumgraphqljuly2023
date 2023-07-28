package com.optum.customerapidgs.fetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.optum.customerapidgs.dtos.AddressInput;
import com.optum.customerapidgs.dtos.CustomerInput;
import com.optum.customerapidgs.exceptions.NoDataFoundError;
import com.optum.customerapidgs.models.Address;
import com.optum.customerapidgs.models.Customer;
import com.optum.customerapidgs.models.FullName;
import com.optum.customerapidgs.repositories.AddressRepo;
import com.optum.customerapidgs.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class CustomerFetcher {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AddressRepo addressRepo;


    //queries
    @DgsQuery
    public List<Customer> findAllCustomers(){

        return this.customerRepo.findAll();
    }


    @DgsQuery
    public Customer findCustomerById(long customerId){

        Customer Customer=this.customerRepo.findById(customerId).orElse(null);
        if (Customer==null)
            throw new NoDataFoundError("Data Not Found","10001");
        else
            return Customer;
    }


    @DgsMutation
    public Customer addCustomer(CustomerInput customerInput){



        Customer customer=Customer.builder()
                .customerId(0)
                .name(FullName.builder()
                        .firstName(customerInput.getName().getFirstName())
                        .lastName(customerInput.getName().getLastName())
                        .middleName(customerInput.getName().getMiddleName())
                        .build())
                .contactNo(customerInput.getContactNo())

                .email(customerInput.getEmail())
                .password(customerInput.getPassword())

                .build();

       Customer customerResponse=this.customerRepo.save(customer);
       if(customerInput.getAddresses().size()>0){
           for(AddressInput addressInput : customerInput.getAddresses()){
               Address address = Address.builder()
                       .addressId(addressInput.getAddressId())
                       .city(addressInput.getCity())
                       .doorNo(addressInput.getDoorNo())
                       .streetName(addressInput.getStreetName())
                       .pincode(addressInput.getPincode())
                       .customer(customer)
                       .build();
               this.addressRepo.save(address);
           }
       }

        customerResponse.setAddresses(mapAccountAddresss(customerInput.getAddresses()));
        return customerResponse;
    }


    private List<Address> mapAccountAddresss(List<AddressInput> addrInput) {
        List<Address> addresssList = addrInput.stream().map(addressInput -> {
            Address address = Address.builder()
                    .addressId(addressInput.getAddressId())
                    .city(addressInput.getCity())
                    .doorNo(addressInput.getDoorNo())
                    .streetName(addressInput.getStreetName())
                    .pincode(addressInput.getPincode())
                    .build();
            return address;
        }).collect(Collectors.toList());
        return addresssList;
    }

}

