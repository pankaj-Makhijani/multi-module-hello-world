package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorldApplication.class, args);
    }
}

@RestController
class WorldController {
    @GetMapping("/world")
    public String world() {
        return "Hello from Service World!!";
    }
}

