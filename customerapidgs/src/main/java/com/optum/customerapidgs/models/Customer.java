package com.optum.customerapidgs.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    
    private long customerId;
    @Embedded
    private FullName name;
    @Column(name="Contact_No")
    private long contactNo;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    //@JsonIgnore
    private List<Address> addresses;
}
