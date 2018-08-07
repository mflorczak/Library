package com.library;

import com.library.domain.BookTitle;
import com.library.domain.CopyBook;
import com.library.repository.BookTitleRepository;
import com.library.repository.CopyBookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyLibraryApplicationTests {

	@Autowired
	BookTitleRepository bookTitleRepository;

	@Autowired
	CopyBookRepository copyBookRepository;

	@Test
	public void testAddCopyBookToTitle() {
		//Given
		BookTitle bookTitle = new BookTitle("Sherlock Holmes", "Arthur Conan Doyle", 1887);
		CopyBook books = new CopyBook("loaned out");
		CopyBook books1 = new CopyBook("lost");

		books.setBookTitle(bookTitle);
		books1.setBookTitle(bookTitle);

		bookTitle.getCopyBookList().add(books);
		bookTitle.getCopyBookList().add(books1);

		//When
		bookTitleRepository.save(bookTitle);
		copyBookRepository.save(books);
		copyBookRepository.save(books1);
		int id = bookTitle.getId();
		int idbooks = books.getId();
		int idbooks1 = books1.getId();

		//Then
		Assert.assertNotEquals(0,id);

		//Clean up
		copyBookRepository.delete(idbooks);
		copyBookRepository.delete(idbooks1);
		bookTitleRepository.delete(id);
	}
}
