package com.optum.customerapidgs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FullNameInput {

    private String firstName;

    private String lastName;

    private String middleName;
}
