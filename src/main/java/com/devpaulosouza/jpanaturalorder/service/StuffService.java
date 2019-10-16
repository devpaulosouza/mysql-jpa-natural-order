package com.devpaulosouza.jpanaturalorder.service;

import com.devpaulosouza.jpanaturalorder.exception.JpaNaturalOrderException;
import com.devpaulosouza.jpanaturalorder.model.Stuff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StuffService {

    Page<Stuff> findAll(Pageable pageable);

    Stuff save(Stuff stuffDto);

    Stuff update(Stuff stuffDto) throws JpaNaturalOrderException;

    void delete(Long id) throws JpaNaturalOrderException;
}