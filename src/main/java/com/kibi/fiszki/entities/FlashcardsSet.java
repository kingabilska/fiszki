package com.kibi.fiszki.entities;

import com.kibi.fiszki.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class FlashcardsSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String detail;
    private Language languages;

    @OneToMany(mappedBy = "flashcardsSet", cascade = CascadeType.ALL)
    private Set<Flashcard> flashcards = new HashSet<>();
}
