package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(
            targetEntity = Borrow.class,
            fetch = FetchType.LAZY,
            mappedBy = "copyBook"
    )
    private List<Borrow> borrows = new ArrayList<>();
}
