package com.generali.legalcasemanagement;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokus")
public class HelloRestController {

    @GetMapping(value="/")
    public String get() {
        return LocalDateTime.now() + " Greetings from Spring Boot! \n";
    }

    @PostMapping(value="/")
    public String post(@RequestBody String postBody) {
        return LocalDateTime.now() + " Greetings from Spring Boot! " + postBody + "\n";
    }
}