package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOKS")
public class CopyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID")
    private int id;

    @Column(name = "STATUS")
    @NotNull
    private String status;

    @ManyToOne
    @JoinColumn(name = "BOOK_TITLE_ID")
    @Setter
    private BookTitle bookTitle;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Borrow.class,
            mappedBy = "reader"

    )
    private List<Borrow> borrowList = new ArrayList<>();

    public CopyBook(String status) {
        this.status = status;
    }
}
