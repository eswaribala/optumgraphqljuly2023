package com.optum.customerapidgs.dtos;


import com.optum.customerapidgs.models.FullName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {

   private FullName name;

   private long contactNo;

   private String email;

   private String password;
   private List<AddressInput> addresses;

   private LocalDate dob;
}
