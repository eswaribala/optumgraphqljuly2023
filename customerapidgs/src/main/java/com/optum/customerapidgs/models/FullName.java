package com.optum.customerapidgs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class FullName {
    @Column(name="First_Name",length = 100,nullable = false)
    private String firstName;
    @Column(name="Last_Name",length = 100,nullable = false)
    private String lastName;
    @Column(name="Middle_Name",length = 100,nullable = true)
    private String middleName;

}
