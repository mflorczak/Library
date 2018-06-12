package com.library.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKS_TITLES")
public class BookTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Ignore
    private int id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "AUTHOR")
    @NotNull
    private String author;

    @Column(name = "PUBLICATION_YEAR")
    @NotNull
    private int publicationOfYear;

    @OneToMany(
            targetEntity = CopyBook.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bookTitle"
    )
    @Setter
    private List<CopyBook> books = new ArrayList<>();

    public BookTitle(String title, String author, int publicationOfYear) {
        this.title = title;
        this.author = author;
        this.publicationOfYear = publicationOfYear;
    }
}
