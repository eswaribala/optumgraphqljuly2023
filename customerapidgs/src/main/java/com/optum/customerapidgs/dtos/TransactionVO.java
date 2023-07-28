package com.optum.customerapidgs.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactions")
public class TransactionVO {

    @BsonId
    private long transactionId;
    private long amount;
    private String timeStamp;
    private String sender;
    private String receiver;
}
