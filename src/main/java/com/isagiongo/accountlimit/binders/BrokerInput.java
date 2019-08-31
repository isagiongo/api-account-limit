package com.isagiongo.accountlimit.binders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

@Configuration
public interface BrokerInput {

    String accountCreated = "ACCOUNT_CREATED";

    @Input(BrokerInput.accountCreated)
    SubscribableChannel accountCreated();
}
