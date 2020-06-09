package com.kibi.fiszki.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{error.notblank}")
    @Size(min = 4, max = 16, message = "{error.wrong.size}")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "{error.notblank}")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,16}", message = "{error.easy.password}")
    private String password;

    @NotBlank(message = "{error.notblank}")
    @Transient
    private String passwordConfirmation;

    private Boolean enabled;
}
