package com.optum.customerapi.dtos;

import com.optum.customerapi.models.FullName;
import com.optum.customerapi.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
