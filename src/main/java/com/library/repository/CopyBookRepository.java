package com.library.repository;

import com.library.domain.CopyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CopyBookRepository extends CrudRepository<CopyBook, Integer> {
    @Override
    List<CopyBook> findAll();
}
