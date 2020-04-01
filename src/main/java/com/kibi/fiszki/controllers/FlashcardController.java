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
}
