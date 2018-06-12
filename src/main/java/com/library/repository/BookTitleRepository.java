package com.library.repository;

import com.library.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BookTitleRepository extends CrudRepository<BookTitle, Integer> {
}
