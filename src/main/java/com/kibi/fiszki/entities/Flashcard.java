package com.kibi.fiszki.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String leftSide;
    @NotBlank
    private String rightSide;

    @JsonIgnore
    @ManyToOne
    private FlashcardsSet flashcardsSet;
}
