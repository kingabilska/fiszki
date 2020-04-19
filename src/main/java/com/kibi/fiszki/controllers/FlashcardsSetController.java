package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.FlashcardsSet;
import com.kibi.fiszki.services.FlashcardsSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;

@Controller
public class FlashcardsSetController {
    @Autowired
    FlashcardsSetService service;

    @GetMapping
    public String getAll(Model model) {
        Iterable<FlashcardsSet> sets = service.getAll();
        model.addAttribute("sets", sets);
        return "set/show";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id, Model model) {
        FlashcardsSet set = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        model.addAttribute("set", set);
        return "set/showOne";
    }

    @GetMapping("/add")
    public String add() {
        return "set/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute FlashcardsSet set) {
        FlashcardsSet saved = service.save(set);
        return "redirect:/" + saved.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        FlashcardsSet set = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        model.addAttribute("set", set);
        return "set/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute FlashcardsSet set) {
        set.setId(id);
        FlashcardsSet saved = service.save(set);
        return "redirect:/" + saved.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        FlashcardsSet set = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        service.delete(set);
        return "redirect:/";
    }
}
