package com.kibi.fiszki.repositories;


import com.kibi.fiszki.entities.Flashcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends CrudRepository<Flashcard, Long> {
}
