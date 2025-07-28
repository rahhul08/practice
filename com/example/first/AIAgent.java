package com.example.first;

public class AIAgent {

    public static void main(String[] args) {
        System.out.println("AI Agent: Hello! How can I help you today?");

        String[] userInputs = {
                "Hello",
                "How are you?",
                "What is your name?",
                "What is the weather like?",
                "Tell me a joke",
                "Goodbye"
        };

        for (String userInput : userInputs) {
            System.out.println("You: " + userInput);
            String agentResponse = getAgentResponse(userInput);
            System.out.println("AI Agent: " + agentResponse);
        }
    }

    public static String getAgentResponse(String userInput) {
        String response;
        userInput = userInput.toLowerCase();

        if (userInput.contains("hello") || userInput.contains("hi")) {
            response = "Hello there!";
        } else if (userInput.contains("how are you")) {
            response = "I'm just a computer program, but I'm doing great! Thanks for asking.";
        } else if (userInput.contains("your name")) {
            response = "I am a simple AI Agent.";
        } else if (userInput.contains("weather")) {
            response = "I'm sorry, I cannot provide real-time information like the weather.";
        } else if (userInput.contains("joke")) {
            response = "Why don't scientists trust atoms? Because they make up everything!";
        } else {
            response = "I'm not sure how to respond to that. Can you ask me something else?";
        }

        return response;
    }
}
