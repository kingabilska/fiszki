package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.Flashcard;
import com.kibi.fiszki.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("flashcard")
public class FlashcardController {
    @Autowired
    FlashcardService service;

    @GetMapping("/add/{id}")
    public String add(@PathVariable Long id, Model model) {
        model.addAttribute("flashcard", new Flashcard());
        model.addAttribute("setId", id);
        return "flashcard/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("flashcard") Flashcard flashcard, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("setId", flashcard.getFlashcardsSet().getId());
            return "flashcard/add";
        }
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

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("flashcard") Flashcard flashcard, BindingResult result) {
        if (result.hasErrors()) {
            return "flashcard/edit";
        }
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
