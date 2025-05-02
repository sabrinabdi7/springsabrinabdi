package com.example.Ca221Projects;
@RestController
public class GreetingController {
    // GET /
    @GetMapping ("/")
    public String welcome() {
        return "Welcome to the REST API!";
    }

    // GET /greet/{name}
    @GetMapping("/greet/{name}")
    public String greet( ) {
        return "Hello,  Bina ! Welcome to our API.";
    }
}

