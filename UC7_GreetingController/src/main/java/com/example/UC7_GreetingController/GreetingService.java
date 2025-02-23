package com.example.UC7_GreetingController;
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

    // Edit (Update) Greeting Message
    public Greeting updateGreeting(Long id, String newMessage) {
        if (newMessage == null || newMessage.trim().isEmpty()) {
            throw new IllegalArgumentException("New greeting message cannot be empty");
        }
        Greeting greeting = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found for ID: " + id));

        greeting.setMessage(newMessage);
        return repository.save(greeting);
    }
}
