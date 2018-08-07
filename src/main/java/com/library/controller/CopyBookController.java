package com.library.controller;

import com.library.domain.BorrowDto;
import com.library.domain.CopyBookDto;
import com.library.mapper.Mapper;
import com.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "v1/copyBook")
public class CopyBookController {

    @Autowired
    private DbService dbService;

    @Autowired
    private Mapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getCopyBooks")
    public List<CopyBookDto> getCopyBooks(){
        return mapper.mapToCopyBookDtoList(dbService.getAllCopyBook());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopyBook")
    public CopyBookDto getCopyBook(@RequestParam int id) throws CopyBookNotFoundException {
        return mapper.mapToCopyBookDto(dbService.findCopyBookById(id).orElseThrow(mapper::createCoppyBookException));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopyBook")
    public CopyBookDto updateCopyBook(@RequestBody CopyBookDto copyBookDto) throws BookTitleNotFoundException {
        return mapper.mapToCopyBookDto(dbService.saveCopyBook(mapper.mapToCopyBook(copyBookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCopyBook", consumes = APPLICATION_JSON_VALUE)
    public void createCopyBook(@RequestBody CopyBookDto copyBookDto) throws BookTitleNotFoundException {
        dbService.saveCopyBook(mapper.mapToCopyBook(copyBookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopyBook")
    public void deleteCopyBook(@RequestParam int id) {
        dbService.deleteCopyBook(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBorrows")
    public List<BorrowDto> getBorrows() {
        return mapper.mapToBorrowDtoList(dbService.getAllBorrow());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBorrow")
    public BorrowDto getBorrow(@RequestParam int id) throws BorrowNotFoundException {
        return mapper.mapToBorrowDto(dbService.findBorrowById(id).orElseThrow(mapper::createBorrowException));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBorrow")
    public BorrowDto updateBorrow(@RequestBody BorrowDto borrowDto) throws ReaderNotFoundException, CopyBookNotFoundException {
        return mapper.mapToBorrowDto(dbService.saveBorrow(mapper.mapToBorrow(borrowDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrow", consumes = APPLICATION_JSON_VALUE)
    public void createBorrow(@RequestBody BorrowDto borrowDto) throws ReaderNotFoundException, CopyBookNotFoundException {
        if(dbService.borrowBook(borrowDto.getCopyBookId(), borrowDto.getReaderId())) {
            dbService.saveBorrow(mapper.mapToBorrow(borrowDto));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBorrow")
    public void deleteBorrow(@RequestParam int id) {
        dbService.deleteBorrow(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getQuantityBook")
    public int getQuantityBook(@RequestParam int book_title_id) {
        return dbService.getQuantity(book_title_id);
    }
}
