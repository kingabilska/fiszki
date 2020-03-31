package com.kibi.fiszki.repositories;

import com.kibi.fiszki.entities.FlashcardsSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardsSetRepository extends CrudRepository<FlashcardsSet, Long> {
}
