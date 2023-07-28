package com.optum.customerapidgs.services;

import com.optum.customerapidgs.dtos.TransactionVO;
import com.optum.customerapidgs.facades.TransactionFacade;
import com.optum.customerapidgs.repositories.TransactionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransactionConsumer {

    @Autowired
    private TransactionRepo transactionRepo;
    public TransactionVO transactionVO;
    public List<TransactionVO> transactions;
    @StreamListener(target = TransactionFacade.inputChannel)
    public void getTransactions(@Payload TransactionVO transactionVO){

        log.info("Message Received "+transactionVO.getTransactionId());
        this.transactionVO=transactionVO;
        this.transactionRepo.save(transactionVO);

    }


    public List<TransactionVO> getTransactions(){

        if(transactionRepo.findAll().size()>0){
            transactions=transactionRepo.findAll();
            return  transactions;
        }
      return transactions;
    }


}
