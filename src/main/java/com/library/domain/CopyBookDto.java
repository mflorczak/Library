package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CopyBookDto {
    private int id;
    private String status;
    private int bookTitleId;
    private List<BorrowDto> borrowDtoList = new ArrayList<>();
}
