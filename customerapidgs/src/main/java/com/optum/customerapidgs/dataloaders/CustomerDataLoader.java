package com.optum.customerapidgs.dataloaders;

import com.netflix.graphql.dgs.DgsDataLoader;

import com.optum.customerapidgs.models.Customer;
import com.optum.customerapidgs.repositories.CustomerRepo;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
/*
@DgsDataLoader(name="cutomers")
public class CustomerDataloader implements BatchLoader<String, Customer> {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CompletionStage<List<Customer>> load(List<String> list) {
        return CompletableFuture.supplyAsync(() -> this.customerRepo.findAllById(list));
    }
}*/
