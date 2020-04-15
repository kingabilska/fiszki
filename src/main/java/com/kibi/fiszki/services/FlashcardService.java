package com.kibi.fiszki.services;

import com.kibi.fiszki.entities.Flashcard;
import com.kibi.fiszki.repositories.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlashcardService {
    @Autowired
    private FlashcardRepository repository;

    public Optional<Flashcard> getById(Long id) {
        return repository.findById(id);
    }

    public Flashcard save(Flashcard flashcards) {
        return repository.save(flashcards);
    }

    public void delete(Flashcard flashcards) {
        repository.delete(flashcards);
    }
}
