package com.optum.customerapi.facades;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.EnableMBeanExport;

@EnableBinding(TransactionFacade.class)
public class StreamConfig {
}
