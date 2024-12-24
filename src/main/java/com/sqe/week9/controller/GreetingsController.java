package com.sqe.week9.controller;

import com.sqe.week9.service.GreetingService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping("/test")
    public String home(Model model) {
        model.addAttribute("currentDateTime", LocalDateTime.now());
        return "this is the server deployment"; // Maps to src/main/resources/templates/index.html
    }
}
