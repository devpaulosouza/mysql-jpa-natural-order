package com.devpaulosouza.jpanaturalorder.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Facade {
    
    @Autowired
    public RepositoryFacade repository;

    @Autowired
    public ServiceFacade service;

}