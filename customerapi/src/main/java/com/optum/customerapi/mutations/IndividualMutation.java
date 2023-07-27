package com.optum.customerapi.mutations;

import com.optum.customerapi.dtos.IndividualInput;
import com.optum.customerapi.models.FullName;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndividualMutation implements GraphQLMutationResolver {

    @Autowired
    private IndividualService individualService;

    public Individual addIndividual(IndividualInput individualInput){

        Individual individual=Individual.builder()
                .customerId(individualInput.getCustomerId())
                .name(FullName.builder()
                        .firstName(individualInput.getName().getFirstName())
                        .lastName(individualInput.getName().getLastName())
                        .middleName(individualInput.getName().getMiddleName())
                        .build())
                .contactNo(individualInput.getContactNo())
                .dob(individualInput.getDob())
                .email(individualInput.getEmail())
                .password(individualInput.getPassword())
                .gender(individualInput.getGender())
                .build();

       return this.individualService.addIndividual(individual);

    }
    public Individual updateIndividual(long customerId, String email){

        return this.individualService.updateIndividual(customerId,email);
    }
    public boolean deleteIndividual(long customerId){

        return this.individualService.deleteIndividual(customerId);
    }
}
