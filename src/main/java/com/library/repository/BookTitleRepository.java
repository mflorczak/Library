package com.library.repository;

import com.library.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookTitleRepository extends CrudRepository<BookTitle, Integer> {
    @Override
    List<BookTitle> findAll();
}
