package com.example.UC3_GreetingController;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> getGreeting() {
        return createResponse("Hello World");
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

        return createResponse(message);
    }

    private Map<String, String> createResponse(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }
}
