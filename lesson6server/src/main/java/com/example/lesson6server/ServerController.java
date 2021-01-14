package com.example.lesson6server;

import org.springframework.web.bind.annotation.*;

@RestController
public class ServerController {

    @GetMapping("/get/{value}")
    public String get(@PathVariable String value) {
        return "return " + value;
    }

    @PostMapping("/post")
    public String post(@RequestBody String body) {
        return "posted " + body;
    }
}
