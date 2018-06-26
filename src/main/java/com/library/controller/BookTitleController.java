package com.library.controller;

import com.library.domain.BookTitleDto;
import com.library.mapper.Mapper;
import com.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path ="/v1/bookTitle" )
public class BookTitleController {
    @Autowired
    private DbService dbService;
    @Autowired
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBookTitles")
    public List<BookTitleDto> getBookTitles() {
        return mapper.mapToBookTitleDtoList(dbService.getAllBookTitle());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookTitle")
    public BookTitleDto getBookTitle(@RequestParam int id) throws BookTitleNotFoundException {
        return mapper.mapToBookTitleDto(dbService.findBookTitleById(id).orElseThrow(mapper::createException));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBookTitle")
    public BookTitleDto updateBookTitle(@RequestParam BookTitleDto bookTitleDto) {
        return mapper.mapToBookTitleDto(dbService.saveBookTitle(mapper.mapToBookTitle(bookTitleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookTitle", consumes = APPLICATION_JSON_VALUE)
    public void createBookTitle(@RequestBody BookTitleDto bookTitleDto){
        dbService.saveBookTitle(mapper.mapToBookTitle(bookTitleDto));
    }
}
