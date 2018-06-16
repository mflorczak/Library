package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "BORROWS")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "COPY_BOOK_ID")
    private CopyBook copyBook;
    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @NotNull
    @Column(name = "BORROW_DATE")
    private LocalDate borrowDate;

    @NotNull
    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;
}
