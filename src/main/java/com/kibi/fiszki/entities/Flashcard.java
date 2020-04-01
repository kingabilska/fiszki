package com.kibi.fiszki.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Flashcard {

//	fill me up :P

	@ManyToOne
	@JoinColumn
	private FlashcardsSet flashcardsSet;
}
