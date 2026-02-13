//package com.nyasha.vitals_management.config;
//
//import org.axonframework.axonserver.connector.AxonServerConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AxonConfig {
//
//    @Bean
//    @ConditionalOnMissingBean(AxonServerConfiguration.class)
//    public AxonServerConfiguration axonServerConfiguration() {
//        AxonServerConfiguration config = new AxonServerConfiguration();
//        config.setServers("localhost:8124");
//        return config;
//    }
//}
