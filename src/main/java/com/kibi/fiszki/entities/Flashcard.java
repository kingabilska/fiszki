package com.kibi.fiszki.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leftSide;
    private String rightSide;

    @ManyToOne
    @JoinColumn
    private FlashcardsSet flashcardsSet;
}
