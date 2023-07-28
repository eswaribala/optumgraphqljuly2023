package com.optum.customerapidgs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualFilter {

    private FilterField customerId;
    private FilterField email;
    private GenderFilterField gender;
}
