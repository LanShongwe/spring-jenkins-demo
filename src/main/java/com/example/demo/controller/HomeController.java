package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(name = "name", defaultValue = "Jenkins") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("timestamp", Instant.now().toString());
        return "index";
    }

    @GetMapping("/api/status")
    @ResponseBody
    public Map<String, String> status() {
        return Map.of(
                "status", "UP",
                "application", "spring-jenkins-demo",
                "timestamp", Instant.now().toString()
        );
    }
}
