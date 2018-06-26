package com.library.repository;

import com.library.domain.CopyBook;
import com.library.domain.CopyBookQuantityDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CopyBookRepository extends CrudRepository<CopyBook, Integer> {
    @Override
    List<CopyBook> findAll();

    Optional<CopyBook> findById(int copyBookId);
    @Query(nativeQuery = true)
    int quantityBook(@Param("book_title_id") int book_title_id);
}
