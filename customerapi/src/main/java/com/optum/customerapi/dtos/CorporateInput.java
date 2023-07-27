package com.optum.customerapi.dtos;

import com.optum.customerapi.models.CompanyType;
import com.optum.customerapi.models.FullName;
import com.optum.customerapi.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateInput {
    private long customerId;
    private FullName name;

    private long contactNo;

    private String email;

    private String password;
    private CompanyType companyType;
}