package com.example.UC4_GreetingController;

import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        String firstName = request.getOrDefault("firstName", "");
        String lastName = request.getOrDefault("lastName", "");
        return greetingService.postGreeting(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Map<String, String>> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
