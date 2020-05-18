package com.kibi.fiszki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String show() {
        return "home";
    }

    @PostMapping("/registration")
    public String register() {
        return "home";
    }
}