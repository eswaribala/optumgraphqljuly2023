package com.optum.customerapidgs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Address_Id")
    private long addressId;
    @Column(name="Door_No",length = 5,nullable = false)
    private String doorNo;
    @Column(name="Street_Name",length = 100,nullable = false)
    private String streetName;
    @Column(name="City",length = 100,nullable = false)
    private String city;
    @Column(name="Pincode")
    private long pincode;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Ind_Customer_Id"), name = "Ind_Customer_Id")
    private Individual individual;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Corp_Customer_Id"), name = "Corp_Customer_Id")
    private Corporate corporate;
}
