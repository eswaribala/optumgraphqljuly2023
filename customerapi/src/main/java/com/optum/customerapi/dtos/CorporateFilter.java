package com.optum.customerapi.dtos;

import com.optum.customerapi.models.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateFilter {

    private FilterField companyType;
}
