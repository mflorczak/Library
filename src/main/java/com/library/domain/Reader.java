package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "READERS")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="NAMES")
    @NotNull
    private String name;

    @Column(name = "LASTNAMES")
    @NotNull
    private String lastname;

    @Column(name = "CREATE_ACCOUNTS")
    @NotNull
    private LocalDate createAccount;
}
