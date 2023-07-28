package com.optum.customerapi.repositories;

import com.optum.customerapi.dtos.TransactionVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepo extends MongoRepository<TransactionVO, Long> {
}
