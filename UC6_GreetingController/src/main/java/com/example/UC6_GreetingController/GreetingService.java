package com.example.UC6_GreetingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreetingService {
    @Autowired
    private GreetingRepository repository;

    // Save Greeting
    public Greeting saveGreeting(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Greeting message cannot be empty");
        }
        Greeting greeting = new Greeting(message);
        return repository.save(greeting);
    }

    // Find Greeting by ID
    public Greeting getGreetingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found for ID: " + id));
    }

    // List All Greetings
    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }
}
