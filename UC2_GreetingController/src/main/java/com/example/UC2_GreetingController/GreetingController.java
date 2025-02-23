package com.example.UC2_GreetingController;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        return greetingService.getGreeting();
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        String name = request.getOrDefault("name", "Guest");
        return greetingService.postGreeting(name);
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        String name = request.getOrDefault("name", "Unknown");
        return greetingService.putGreeting(name);
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        return greetingService.deleteGreeting();
    }
}
