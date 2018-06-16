package com.library.service;

import com.library.domain.BookTitle;
import com.library.domain.Borrow;
import com.library.domain.CopyBook;
import com.library.domain.Reader;
import com.library.repository.BookTitleRepository;
import com.library.repository.BorrowRepository;
import com.library.repository.CopyBookRepository;
import com.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private BookTitleRepository bookTitleRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private CopyBookRepository copyBookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public BookTitle findBookTitleById(final int bookTitleId) {
        return bookTitleRepository.findOne(bookTitleId);
    }

    public Borrow findBorrowById(final int borrowId) {
        return borrowRepository.findOne(borrowId);
    }

    public CopyBook findCopyBookById(final int copyBook) {
        return copyBookRepository.findOne(copyBook);
    }

    public Reader findReaderById(final int readerId) {
        return readerRepository.findOne(readerId);
    }

    public List<BookTitle> getAllBookTitle() {
        return bookTitleRepository.findAll();
    }

    public List<Borrow> getAllBorrow() {
        return borrowRepository.findAll();
    }

    public List<CopyBook> getAllCopyBook() {
        return copyBookRepository.findAll();
    }

    public List<Reader> getAllReader() {
        return readerRepository.findAll();
    }

    public BookTitle saveBookTitle(BookTitle bookTitle) {
        return bookTitleRepository.save(bookTitle);
    }

    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public CopyBook saveCopyBook(CopyBook copyBook) {
        return copyBookRepository.save(copyBook);
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteBookTitle(int id) {
        bookTitleRepository.delete(id);
    }

    public void deleteBorrow(int id) {
        borrowRepository.delete(id);
    }

    public void deleteCopyBook(int id) {
        copyBookRepository.delete(id);
    }

    public void deleteReader(int id) {
        readerRepository.delete(id);
    }
}
