package com.optum.customerapidgs.mutations;

import com.optum.customerapidgs.dtos.CorporateInput;
import com.optum.customerapidgs.models.FullName;
import com.optum.customerapidgs.models.Corporate;
import com.optum.customerapidgs.services.CorporateService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorporateMutation implements GraphQLMutationResolver {

    @Autowired
    private CorporateService corporateService;

    public Corporate addCorporate(CorporateInput corporateInput){

        Corporate corporate=Corporate.builder()
                .customerId(0)
                .name(FullName.builder()
                        .firstName(corporateInput.getName().getFirstName())
                        .lastName(corporateInput.getName().getLastName())
                        .middleName(corporateInput.getName().getMiddleName())
                        .build())
                .contactNo(corporateInput.getContactNo())

                .email(corporateInput.getEmail())
                .password(corporateInput.getPassword())
                .companyType(corporateInput.getCompanyType())
                .build();

       return this.corporateService.addCorporate(corporate);

    }
    public Corporate updateCorporate(long customerId, String email){

        return this.corporateService.updateCorporate(customerId,email);
    }
    public boolean deleteCorporate(long customerId){

        return this.corporateService.deleteCorporate(customerId);
    }
}
