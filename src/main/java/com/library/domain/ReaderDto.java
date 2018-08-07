package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReaderDto {
    private int id;
    private String name;
    private String lastname;
    private LocalDate createAccount;
    private List<BorrowDto> borrowDtoList = new ArrayList<>();
}
