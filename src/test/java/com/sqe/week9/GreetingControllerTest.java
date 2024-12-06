package com.sqe.week9;

import com.sqe.week9.controller.GreetingsController;
import com.sqe.week9.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingsController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        Mockito.reset(greetingService); // Reset the mock to avoid state leakage between tests
        when(greetingService.getGreeting()).thenReturn("Mocked Hello, World!");
    }

    @Test
    public void testGetGreeting() throws Exception {
        // Perform the GET request and verify the response
        mockMvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().string("Mocked Hello, World!"));

        // Verify interaction with the mocked service
        Mockito.verify(greetingService, Mockito.times(1)).getGreeting();
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        @Primary
        public GreetingService greetingService() {
            return Mockito.mock(GreetingService.class);
        }
    }
}