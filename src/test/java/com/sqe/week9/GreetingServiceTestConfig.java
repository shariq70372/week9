package com.sqe.week9;

import com.sqe.week9.service.GreetingService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class GreetingServiceTestConfig {

    @Bean
    public GreetingService greetingService() {
        return Mockito.mock(GreetingService.class);
    }
}

