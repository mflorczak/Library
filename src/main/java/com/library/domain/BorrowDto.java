package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BorrowDto {
    private int id;
    private int copyBookId;
    private int readerId;
    private LocalDate borrowDate;
    private LocalDate returnDate;


}
