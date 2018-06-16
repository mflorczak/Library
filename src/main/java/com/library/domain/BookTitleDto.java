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
public class BookTitleDto {
    private int id;
    private String title;
    private String author;
    private int publicationOfYear;
    private List<CopyBook> books = new ArrayList<>();
}
