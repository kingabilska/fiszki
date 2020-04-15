package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.Flashcard;
import com.kibi.fiszki.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;

@Controller
public class FlashcardController {
    @Autowired
    FlashcardService service;

    @GetMapping("/flashcard/add/{id}")
    public String add(@PathVariable Long id, Model model) {
        model.addAttribute("setId", id);
        return "flashcard/add";
    }

    @PostMapping("/flashcard/add")
    public String add(@ModelAttribute Flashcard flashcard) {
        Flashcard saved = service.save(flashcard);
        return "redirect:/" + saved.getFlashcardsSet().getId();
    }

    @GetMapping("/flashcard/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Flashcard flashcard = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        model.addAttribute("flashcard", flashcard);
        return "flashcard/edit";
    }

    @PostMapping("/flashcard/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Flashcard flashcard) {
        flashcard.setId(id);
        Flashcard saved = service.save(flashcard);
        return "redirect:/" + saved.getFlashcardsSet().getId();
    }

    @GetMapping("/flashcard/delete/{id}")
    public String delete(@PathVariable Long id) {
        Flashcard flashcard = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        service.delete(flashcard);
        return "redirect:/" + flashcard.getFlashcardsSet().getId();
    }
}
