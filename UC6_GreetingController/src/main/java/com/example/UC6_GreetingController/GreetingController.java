package com.example.UC6_GreetingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService service;

    // Save Greeting Message
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestParam String message) {
        return service.saveGreeting(message);
    }

    // Get Greeting by ID
    @GetMapping("/{id}")
    public Greeting getGreeting(@PathVariable Long id) {
        return service.getGreetingById(id);
    }

    // Get All Greetings
    @GetMapping("/list")
    public List<Greeting> getAllGreetings() {
        return service.getAllGreetings();
    }
}
