package com.optum.customerapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface TransactionFacade {

    String inputChannel="in-channel";

    @Input(inputChannel)
    MessageChannel inChannel();
}
