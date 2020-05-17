package com.kibi.fiszki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity(name = "flashcards")
public class Flashcard extends AbstractEntity {

    @NotBlank(message = "{error.notblank}")
    private String leftSide;
    @NotBlank(message = "{error.notblank}")
    private String rightSide;

    @JsonIgnore
    @ManyToOne
    private FlashcardsSet flashcardsSet;
}
