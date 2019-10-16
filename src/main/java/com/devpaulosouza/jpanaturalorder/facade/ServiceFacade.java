package com.devpaulosouza.jpanaturalorder.facade;

import com.devpaulosouza.jpanaturalorder.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade {

    @Autowired
    public StuffService stuff;

}