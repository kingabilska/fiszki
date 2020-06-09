package com.kibi.fiszki.repositories;

import com.kibi.fiszki.entities.Flashcard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends PagingAndSortingRepository<Flashcard, Long> {
    Page<Flashcard> findByFlashcardsSetId(Long id, Pageable pageable);
}
