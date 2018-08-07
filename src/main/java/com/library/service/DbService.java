package com.library.service;

import com.library.domain.*;
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

    public Optional<BookTitle> findBookTitleById(final int bookTitleId) {
        return bookTitleRepository.findById(bookTitleId);
    }

    public Optional<Borrow> findBorrowById(final int borrowId) {
        return borrowRepository.findById(borrowId);
    }

    public Optional<CopyBook> findCopyBookById(final int copyBook) {
        return copyBookRepository.findById(copyBook);
    }

    public Optional<Reader> findReaderById(final int readerId) {
        return readerRepository.findById(readerId);
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

    public BookTitle saveBookTitle(final BookTitle bookTitle) {
        return bookTitleRepository.save(bookTitle);
    }

    public Borrow saveBorrow(final Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public CopyBook saveCopyBook(final CopyBook copyBook) {
        return copyBookRepository.save(copyBook);
    }

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteBookTitle(final int id) {
        bookTitleRepository.delete(id);
    }

    public void deleteBorrow(final int id) {
        borrowRepository.delete(id);
    }

    public void deleteCopyBook(final int id) {
        copyBookRepository.delete(id);
    }

    public void deleteReader(final int id) {
        readerRepository.delete(id);
    }

<<<<<<< HEAD
    public int getQuantity(final int id) {
=======
    public int getQuantity(int id) {
>>>>>>> 9525ff312f8ba2f7e8655c9d550db12fca3f5e68
        return copyBookRepository.quantityBook(id);
    }

    public boolean borrowBook(final int copyBookId, final int readerId) {
        return borrowRepository.isBorrow(copyBookId, readerId);
    }
}
