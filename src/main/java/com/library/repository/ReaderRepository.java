package com.library.repository;

import com.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Integer> {
    @Override
    List<Reader> findAll();

    Optional<Reader> findById(int readerId);
}
