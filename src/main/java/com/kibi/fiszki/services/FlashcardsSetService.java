package com.kibi.fiszki.services;

import com.kibi.fiszki.entities.FlashcardsSet;
import com.kibi.fiszki.repositories.FlashcardsSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlashcardsSetService {
    @Autowired
    private FlashcardsSetRepository repository;

    public Iterable<FlashcardsSet> getAll() {
        return repository.findAll();
    }

    public Optional<FlashcardsSet> getById(Long id) {
        return repository.findById(id);
    }

    public FlashcardsSet save(FlashcardsSet set) {
        return repository.save(set);
    }

    public void delete(FlashcardsSet set) {
        repository.delete(set);
    }
}