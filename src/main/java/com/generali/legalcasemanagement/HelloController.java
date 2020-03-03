package com.generali.legalcasemanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generali.legalcasemanagement.entity.Greeting;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String get(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("greeting", new Greeting());
        return "hello";
    }

    @PostMapping
    public String post(@ModelAttribute Greeting greeting, Model model) {

        model.addAttribute("greeting", greeting);
        return "result";
    }
}