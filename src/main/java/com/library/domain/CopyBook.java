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
@NamedNativeQuery(
        name = "CopyBook.quantityBook",
        query = "SELECT COUNT(*) AS QUANTITY FROM " +
<<<<<<< HEAD
                "books WHERE status = \"in a warehouse\" AND book_title_id = :book_title_id")
=======
                "books WHERE status = \"in a warehouse\" AND book_title_id = :book_title_id"
        )
>>>>>>> 9525ff312f8ba2f7e8655c9d550db12fca3f5e68
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
