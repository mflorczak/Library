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
@NamedNativeQuery(
        name = "Borrow.isBorrow",
        query = "SELECT IsBorrow(:C_ID, :R_ID)"
)
@Entity(name = "BORROWS")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "COPY_BOOK_ID")
    @NotNull
    private CopyBook copyBook;

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    @NotNull
    private Reader reader;

    @NotNull
    @Column(name = "BORROW_DATE")
    private LocalDate borrowDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;
}
