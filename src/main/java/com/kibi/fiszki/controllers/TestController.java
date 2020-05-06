package com.kibi.fiszki.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {

    @GetMapping({"/test/{id}"})
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("setId", id);
        return "test";
    }
}
