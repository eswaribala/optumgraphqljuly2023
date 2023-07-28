package com.optum.customerapidgs.repositories;

import com.optum.customerapidgs.dtos.TransactionVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepo extends MongoRepository<TransactionVO, Long> {
}
