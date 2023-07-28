package com.optum.customerapidgs.dtos;

import com.optum.customerapidgs.models.CompanyType;
import com.optum.customerapidgs.models.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateInput {

    private FullName name;

    private long contactNo;

    private String email;

    private String password;
    private CompanyType companyType;
}