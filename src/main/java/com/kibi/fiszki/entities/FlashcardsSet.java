package com.kibi.fiszki.entities;

import com.kibi.fiszki.enums.Language;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "flashcards_sets")
public class FlashcardsSet extends AbstractEntity {

    @NotBlank(message = "{error.notblank}")
    private String title;
    private String detail;
    @NotNull(message = "{error.notnull}")
    private Language languages;

    @OneToMany(mappedBy = "flashcardsSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Flashcard> flashcards = new HashSet<>();
}
