package com.devpaulosouza.jpanaturalorder.repository;

import com.devpaulosouza.jpanaturalorder.model.Stuff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StuffRepository extends JpaRepository<Stuff, Long> {

    @Query("FROM Stuff s ")
    Page<Stuff> findAll(Pageable pageable);

}