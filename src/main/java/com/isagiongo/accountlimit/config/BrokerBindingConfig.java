package com.isagiongo.accountlimit.config;


import com.isagiongo.accountlimit.binders.BrokerInput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({BrokerInput.class})
public class BrokerBindingConfig {
}
