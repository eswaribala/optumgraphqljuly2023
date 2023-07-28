package com.optum.customerapidgs.dtos;

import com.optum.customerapidgs.models.FullName;
import com.optum.customerapidgs.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualInput {

   private FullName name;

   private long contactNo;

   private String email;

   private String password;

   private Gender gender;
   private LocalDate dob;
}
