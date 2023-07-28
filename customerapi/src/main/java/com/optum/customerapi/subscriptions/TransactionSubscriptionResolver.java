package com.optum.customerapi.subscriptions;

import com.optum.customerapi.dtos.TransactionVO;
import com.optum.customerapi.services.TransactionConsumer;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class TransactionSubscriptionResolver implements GraphQLSubscriptionResolver {

    @Autowired
    private TransactionConsumer transactionConsumer;


    public Publisher<TransactionVO> transactions(){


        return Flux.interval(Duration.ofSeconds(5))
        .map(num -> transactionConsumer.transactionVO );

    }


}
