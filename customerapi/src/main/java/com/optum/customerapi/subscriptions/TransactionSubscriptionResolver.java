package com.optum.customerapi.subscriptions;

import com.optum.customerapi.dtos.TransactionVO;
import com.optum.customerapi.repositories.TransactionRepo;
import com.optum.customerapi.services.TransactionConsumer;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionSubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    private TransactionConsumer transactionConsumer;
    private TransactionRepo transactionRepo;

    public Publisher<TransactionVO> transactions(long transactionId){


        return Flux.interval(Duration.ofSeconds(5))

        .map(num -> transactionRepo.findById(transactionId).orElse(null));

    }


}
