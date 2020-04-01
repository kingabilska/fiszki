package com.kibi.fiszki.services;

import com.kibi.fiszki.entities.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlashcardService {
	@Autowired
	private FlashcardRepository repository;
}
