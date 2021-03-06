package com.devpaulosouza.jpanaturalorder.controller;

import com.devpaulosouza.jpanaturalorder.exception.JpaNaturalOrderException;
import com.devpaulosouza.jpanaturalorder.facade.Facade;
import com.devpaulosouza.jpanaturalorder.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stuff")
public class StuffController {

    @Autowired
    private Facade facade;
    
    @GetMapping
    public Page<Stuff> findAll(Pageable pageable) {
        return facade.service.stuff.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Stuff> create(@RequestBody Stuff stuffDto) {
        Stuff stuff = facade.service.stuff.save(stuffDto);

        return ResponseEntity.ok(stuff);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Stuff stuffDto) throws JpaNaturalOrderException {
        Stuff stuff = facade.service.stuff.update(stuffDto);

        return ResponseEntity.ok(stuff);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") Long id) throws JpaNaturalOrderException {
        facade.service.stuff.delete(id);

        return ResponseEntity.ok().build();
    }

}