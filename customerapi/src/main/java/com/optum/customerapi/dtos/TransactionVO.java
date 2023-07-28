package com.optum.customerapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionVO {

    private long transactionId;
    private long amount;
    private String timeStamp;
    private String sender;
    private String receiver;
}
