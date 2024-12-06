package com.sqe.week9.controller;

import com.sqe.week9.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    public final GreetingService greetingService;

    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public String getGreetings(){
        return greetingService.getGreeting();
    }
}
