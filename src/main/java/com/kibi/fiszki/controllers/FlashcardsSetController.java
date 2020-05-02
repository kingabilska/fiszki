package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.FlashcardsSet;
import com.kibi.fiszki.services.FlashcardsSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import static com.kibi.fiszki.Constants.DEFAULT_PAGE;
import static com.kibi.fiszki.Constants.DEFAULT_PAGE_SIZE;

@Controller
@RequestMapping("set")
public class FlashcardsSetController {
    @Autowired
    FlashcardsSetService service;

    @GetMapping
    public String getAll(@RequestParam(defaultValue = DEFAULT_PAGE) Integer page,
                         @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                         Model model) {
        Page<FlashcardsSet> pageSet = service.getAll(page, size);
        int shift = page * size;
        model.addAttribute("page", pageSet);
        model.addAttribute("shift", shift);
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
    public String add(Model model) {
        model.addAttribute("set", new FlashcardsSet());
        return "set/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("set") FlashcardsSet set, BindingResult result) {
        if (result.hasErrors()) {
            return "set/add";
        }
        FlashcardsSet saved = service.save(set);
        return "redirect:/set/" + saved.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        FlashcardsSet set = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        model.addAttribute("set", set);
        return "set/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       @Valid @ModelAttribute("set") FlashcardsSet set, BindingResult result) {
        if (result.hasErrors()) {
            return "set/edit";
        }
        set.setId(id);
        FlashcardsSet saved = service.save(set);
        return "redirect:/set/" + saved.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        FlashcardsSet set = service.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        service.delete(set);
        return "redirect:/set/";
    }
}
