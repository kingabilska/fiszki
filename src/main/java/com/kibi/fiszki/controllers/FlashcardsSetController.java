package com.kibi.fiszki.controllers;

import com.kibi.fiszki.entities.Flashcard;
import com.kibi.fiszki.entities.FlashcardsSet;
import com.kibi.fiszki.services.FlashcardService;
import com.kibi.fiszki.services.FlashcardsSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import static com.kibi.fiszki.Constants.DEFAULT_SORT_FIELD;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Controller
@RequestMapping("set")
public class FlashcardsSetController {
    @Autowired
    FlashcardsSetService setService;
    @Autowired
    FlashcardService flashcardService;

    @GetMapping
    public String getAll(@SortDefault(sort = DEFAULT_SORT_FIELD, direction = DESC) Pageable pageable,
                         @RequestParam(required = false) String login, Model model) {
        Page<FlashcardsSet> pageSet;
        if (login != null) {
            pageSet = setService.getAllByCreator(login, pageable);
        } else {
            pageSet = setService.getAll(pageable);
        }
        model.addAttribute("page", pageSet);
        return "set/show";
    }

    @GetMapping("/{id}")
    public String getOne(@SortDefault(sort = DEFAULT_SORT_FIELD, direction = DESC) Pageable pageable,
                         @PathVariable Long id, Model model) {
        FlashcardsSet set = setService.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        Page<Flashcard> flashcardsPage = flashcardService.getBySetId(id, pageable);
        model.addAttribute("set", set);
        model.addAttribute("flashcardsPage", flashcardsPage);
        return "set/showOne";
    }

    @ResponseBody
    @GetMapping(value = "test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FlashcardsSet getForTest(@PathVariable Long id) {
        FlashcardsSet set = setService.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        return set;
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
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        set.setCreator(user.getUsername());
        FlashcardsSet saved = setService.save(set);
        return "redirect:/set/" + saved.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        FlashcardsSet set = setService.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        model.addAttribute("set", set);
        return "set/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("set") FlashcardsSet set, BindingResult result) {
        if (result.hasErrors()) {
            return "set/edit";
        }
        FlashcardsSet saved = setService.save(set);
        return "redirect:/set/" + saved.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        FlashcardsSet set = setService.getById(id)
                .orElseThrow(EntityNotFoundException::new);
        setService.delete(set);
        return "redirect:/set/";
    }
}
