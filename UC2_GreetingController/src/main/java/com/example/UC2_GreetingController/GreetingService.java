package com.example.UC2_GreetingController;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello World");
        return response;
    }

    public Map<String, String> postGreeting(String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from POST");
        response.put("received", name);
        return response;
    }

    public Map<String, String> putGreeting(String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from PUT");
        response.put("updated", name);
        return response;
    }

    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from DELETE");
        return response;
    }
}
