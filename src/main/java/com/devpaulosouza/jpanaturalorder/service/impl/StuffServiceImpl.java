package com.devpaulosouza.jpanaturalorder.service.impl;

import com.devpaulosouza.jpanaturalorder.exception.JpaNaturalOrderException;
import com.devpaulosouza.jpanaturalorder.facade.Facade;
import com.devpaulosouza.jpanaturalorder.model.Stuff;
import com.devpaulosouza.jpanaturalorder.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StuffServiceImpl implements StuffService {

    @Autowired
    private Facade facade;

    @Override
    public Page<Stuff> findAll(Pageable pageable) {
        Pageable customPageable;

        Sort.Order order = pageable.getSort().getOrderFor("name");

        if (Objects.nonNull(order)) {
            Sort sort = JpaSort.unsafe(order.getDirection(), "natsort_canon(name, 'natural')");

            customPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        } else {
            customPageable = pageable;
        }

        return facade.repository.stuff.findAll(customPageable);
    }

    @Override
    public Stuff save(Stuff stuffDto) {
        return facade.repository.stuff.save(stuffDto);
    }

    @Override
    public Stuff update(Stuff stuffDto) throws JpaNaturalOrderException {
        if (Objects.isNull(stuffDto) || Objects.isNull(stuffDto.getId())) {
            throw new JpaNaturalOrderException("Stuff's id is required");
        }

        Stuff stuff = facade.repository.stuff.getOne(stuffDto.getId());

        if (Objects.isNull(stuff)) {
            throw new JpaNaturalOrderException("Stuff not found");
        }

        return facade.repository.stuff.save(stuffDto);
    }

    @Override
    public void delete(Long id) throws JpaNaturalOrderException {
        Stuff stuff = facade.repository.stuff.getOne(id);

        if (Objects.isNull(stuff)) {
            throw new JpaNaturalOrderException("Stuff not found");
        }

        facade.repository.stuff.delete(stuff);
    }

}