package com.library.mapper;

import com.library.controller.BookTitleNotFoundException;
import com.library.controller.BorrowNotFoundException;
import com.library.controller.CopyBookNotFoundException;
import com.library.controller.ReaderNotFoundException;
import com.library.domain.*;
import com.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mapper {
    @Autowired
    private DbService dbService;

    public BookTitleNotFoundException createBookTitleException() {
        return new BookTitleNotFoundException("Not found BookTitle id");
    }

    public ReaderNotFoundException createReaderException() {
        return new ReaderNotFoundException("Not found Reader id");
    }

    public CopyBookNotFoundException createCoppyBookException() {
        return new CopyBookNotFoundException("Not found CopyBook id");
    }

    public BorrowNotFoundException createBorrowException() {
        return new BorrowNotFoundException("Not fund Borrow id");
    }

    public CopyBook mapToCopyBook(CopyBookDto copyBookDto) throws BookTitleNotFoundException {
        CopyBook cb = new CopyBook();
        cb.setId(copyBookDto.getId());
        cb.setStatus(copyBookDto.getStatus());
        cb.setBookTitle(dbService.findBookTitleById(copyBookDto.getBookTitleId()).orElseThrow(this::createBookTitleException));
        cb.setBorrowList(copyBookDto.getBorrowList());
        return cb;
    }

    public CopyBookDto mapToCopyBookDto(CopyBook copyBook) {
        CopyBookDto copyBookDto = new CopyBookDto();
        copyBookDto.setId(copyBook.getId());
        copyBookDto.setStatus(copyBook.getStatus());
        copyBookDto.setBookTitleId(copyBook.getBookTitle().getId());
        copyBookDto.setBorrowList(copyBook.getBorrowList());
        return copyBookDto;
    }

    public List<CopyBookDto> mapToCopyBookDtoList(List<CopyBook> copyBookList) {
        return copyBookList.stream()
                .map(b -> new CopyBookDto(b.getId(), b.getStatus(), b.getBookTitle().getId(), b.getBorrowList()))
                .collect(Collectors.toList());
    }

    public BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        BookTitle bookTitle = new BookTitle();
        bookTitle.setId(bookTitleDto.getId());
        bookTitle.setTitle(bookTitleDto.getTitle());
        bookTitle.setAuthor(bookTitleDto.getAuthor());
        bookTitle.setPublicationOfYear(bookTitleDto.getPublicationOfYear());
        bookTitle.setCopyBookList(bookTitleDto.getBooks());
        return bookTitle;
    }

    public BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        BookTitleDto bookTitleDto = new BookTitleDto();
        bookTitleDto.setId(bookTitle.getId());
        bookTitleDto.setAuthor(bookTitle.getAuthor());
        bookTitleDto.setPublicationOfYear(bookTitle.getPublicationOfYear());
        bookTitleDto.setBooks(bookTitle.getCopyBookList());
        return bookTitleDto;
    }

    public List<BookTitleDto> mapToBookTitleDtoList(List<BookTitle> bookTitleList) {
        return bookTitleList.stream()
                .map(b -> new BookTitleDto(b.getId(), b.getTitle(), b.getAuthor(), b.getPublicationOfYear(), b.getCopyBookList()))
                .collect(Collectors.toList());
    }

    public Borrow mapToBorrow(BorrowDto borrowDto) throws ReaderNotFoundException, CopyBookNotFoundException {
        Borrow borrow = new Borrow();
        borrow.setId(borrowDto.getId());
        borrow.setCopyBook(dbService.findCopyBookById(borrowDto.getCopyBookId()).orElseThrow(this::createCoppyBookException));
        borrow.setReader(dbService.findReaderById(borrowDto.getReaderId()).orElseThrow(this::createReaderException));
        borrow.setBorrowDate(borrowDto.getBorrowDate());
        borrow.setReturnDate(borrowDto.getReturnDate());
        return borrow;
    }

    public BorrowDto mapToBorrowDto(Borrow borrow) {
        BorrowDto borrowDto = new BorrowDto();
        borrowDto.setId(borrow.getId());
        borrowDto.setCopyBookId(borrow.getCopyBook().getId());
        borrowDto.setReaderId(borrow.getReader().getId());
        borrowDto.setBorrowDate(borrow.getBorrowDate());
        borrowDto.setReturnDate(borrow.getReturnDate());
        return borrowDto;
    }

    public List<BorrowDto> mapToBorrowDtoList(List<Borrow> borrowList) {
        return borrowList.stream()
                .map(b -> new BorrowDto(b.getId(), b.getCopyBook().getId(),
                        b.getReader().getId(), b.getBorrowDate(), b.getReturnDate()))
                .collect(Collectors.toList());
    }

    public Reader mapToReader(ReaderDto readerDto) {
        Reader reader = new Reader();
        reader.setId(readerDto.getId());
        reader.setName(readerDto.getName());
        reader.setLastname(readerDto.getLastname());
        reader.setCreateAccount(readerDto.getCreateAccount());
        reader.setBorrows(readerDto.getBorrowList());
        return reader;
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setId(reader.getId());
        readerDto.setName(reader.getName());
        readerDto.setLastname(reader.getLastname());
        readerDto.setCreateAccount(reader.getCreateAccount());
        readerDto.setBorrowList(reader.getBorrows());
        return readerDto;
    }

    public List<ReaderDto> mapToReaderDtoList(List<Reader> readerList) {
        return readerList.stream()
                .map(r -> new ReaderDto(r.getId(), r.getName(), r.getLastname(), r.getCreateAccount(), r.getBorrows()))
                .collect(Collectors.toList());
    }
}
