package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.User;
import com.kibi.fiszki.services.UserService;
import com.kibi.fiszki.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthenticationController {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping("authentication")
    public String register(@ModelAttribute("user") User user, @RequestParam(required = false) Boolean error, Model model) {
        model.addAttribute("loginError", error);
        return "authentication";
    }

    @PostMapping("registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("username", user.getUsername());
            return "authentication";
        }
        userService.registerAndAuthUser(request, user.getUsername(), user.getPassword());
        return "home";
    }
}
