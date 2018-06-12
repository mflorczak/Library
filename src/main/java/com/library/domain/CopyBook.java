package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKS")
public class CopyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "STATUS")
    @NotNull
    private String status;

    @ManyToOne
    @JoinColumn(name = "BOOK_TITLE_ID")
    @Setter
    private BookTitle bookTitle;

    public CopyBook(String status) {
        this.status = status;
    }
}
