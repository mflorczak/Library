package com.library.repository;

import com.library.domain.Borrow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Integer> {
    @Override
    List<Borrow> findAll();

    Optional<Borrow> findById(int borrowId);

    @Query(nativeQuery = true)
    boolean isBorrow(@Param("C_ID") int cId, @Param("R_ID") int rId);
}
