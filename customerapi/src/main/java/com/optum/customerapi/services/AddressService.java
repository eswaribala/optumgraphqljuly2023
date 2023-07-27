package com.optum.customerapi.services;

import com.optum.customerapi.models.Address;
import com.optum.customerapi.models.Corporate;
import com.optum.customerapi.models.Customer;
import com.optum.customerapi.models.Individual;
import com.optum.customerapi.repositories.AddressRepo;
import com.optum.customerapi.repositories.CorporateRepo;
import com.optum.customerapi.repositories.CustomerRepo;
import com.optum.customerapi.repositories.IndividualRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private IndividualRepo individualRepo;

    @Autowired
    private CorporateRepo corporateRepo;

    @Autowired
    private EntityManager entityManager;

    //insert

    public Address addIndividualAddress(Address address,long customerId){

        Individual individual=this.individualRepo.findById(customerId).orElse(null);
        if(individual!=null){
            address.setIndividual(individual);
            return this.addressRepo.save(address);
        }
        else
            return null;


    }

    public Address addCorporateAddress(Address address,long customerId){

        Corporate corporate =this.corporateRepo.findById(customerId).orElse(null);
        if(corporate!=null){
            address.setCorporate(corporate);
            return this.addressRepo.save(address);
        }
        else
            return null;


    }
    //select all

    public List<Address> getAllAddresss(){
        return this.addressRepo.findAll();
    }

    //select by id

    public List<Address> getAddressByIndividualCustomerId(long customerId){
        return this.addressRepo.findByIndividualCustomerId(customerId);
    }

    public List<Address> getAddressByCorporateCustomerId(long customerId){
        return this.addressRepo.findByCorporateCustomerId(customerId);
    }


    //update

    public Address updateIndividualAddress(Address address,long customerId){
      Individual individual=this.individualRepo.findById(customerId).orElse(null);
        if(individual!=null){
            address.setIndividual(individual);
            return this.addressRepo.save(address);
        }
        else
            return null;
    }
    public Address updateCorporateAddress(Address address,long customerId){
        Corporate corporate =this.corporateRepo.findById(customerId).orElse(null);
        if(corporate!=null){
            address.setCorporate(corporate);
            return this.addressRepo.save(address);
        }
        else
            return null;
    }

    //delete
    public boolean deleteAddress(long addressId){
        boolean status=false;
        this.addressRepo.deleteById(addressId);
        status=true;

        return status;
    }
}
