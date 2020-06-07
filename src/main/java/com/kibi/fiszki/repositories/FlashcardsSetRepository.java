package com.kibi.fiszki.repositories;

import com.kibi.fiszki.entities.FlashcardsSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardsSetRepository extends PagingAndSortingRepository<FlashcardsSet, Long> {
    Page<FlashcardsSet> findAllByCreator(String login, Pageable pageable);
}
