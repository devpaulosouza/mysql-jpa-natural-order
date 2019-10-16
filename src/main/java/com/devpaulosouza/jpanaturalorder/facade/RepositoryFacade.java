package com.devpaulosouza.jpanaturalorder.facade;

import com.devpaulosouza.jpanaturalorder.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryFacade {

    @Autowired
    public StuffRepository stuff;
    
}
