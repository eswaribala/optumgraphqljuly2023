package com.optum.customerapi.dtos;

import com.optum.customerapi.models.Customer;
import com.optum.customerapi.models.Individual;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {
    private long addressId;
    private String doorNo;
    private String streetName;
    private String city;
    private long pincode;
    private Individual individual;
}
