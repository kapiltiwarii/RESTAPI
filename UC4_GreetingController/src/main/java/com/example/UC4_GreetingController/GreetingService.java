package com.example.UC4_GreetingController;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Map<String, String> getGreeting() {
        String message = "Hello World";
        greetingRepository.save(new Greeting(message));
        return createResponse(message);
    }

    public Map<String, String> postGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        greetingRepository.save(new Greeting(message));
        return createResponse(message);
    }

    public List<Map<String, String>> getAllGreetings() {
        return greetingRepository.findAll()
                .stream()
                .map(greeting -> createResponse(greeting.getMessage()))
                .collect(Collectors.toList());
    }

    private Map<String, String> createResponse(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }
}
