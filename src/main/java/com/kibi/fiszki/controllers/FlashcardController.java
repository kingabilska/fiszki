package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.Flashcard;
import com.kibi.fiszki.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("flashcard")
public class FlashcardController {
    @Autowired
    FlashcardService service;

    @GetMapping("/add/{id}")
    public String add(@PathVariable Long id, Model model) {
        model.addAttribute("setId", id);
        return "flashcard/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Flashcard flashcard) {
        Flashcard saved = service.save(flashcard);
        return "redirect:/set/" + saved.getFlashcardsSet().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Flashcard flashcard = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        model.addAttribute("flashcard", flashcard);
        return "flashcard/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute Flashcard flashcard) {
        flashcard.setId(id);
        Flashcard saved = service.save(flashcard);
        return "redirect:/set/" + saved.getFlashcardsSet().getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Flashcard flashcard = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        service.delete(flashcard);
        return "redirect:/set/" + flashcard.getFlashcardsSet().getId();
    }
}
