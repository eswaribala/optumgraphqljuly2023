package com.optum.customerapi.services;

import com.optum.customerapi.dtos.TransactionVO;
import com.optum.customerapi.facades.TransactionFacade;
import com.optum.customerapi.repositories.TransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionConsumer {

    @Autowired
    private TransactionRepo transactionRepo;
    public TransactionVO transactionVO;

    @StreamListener(target = TransactionFacade.inputChannel)
    public void getTransactions(@Payload TransactionVO transactionVO){

        log.info("Message Received "+transactionVO.getTransactionId());
        this.transactionVO=transactionVO;
        this.transactionRepo.save(transactionVO);

    }


}
