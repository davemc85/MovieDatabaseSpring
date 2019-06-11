package com.codeclan.example.MovieDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/actors")
public class ActorController {

    @Autowired
    ActorController actorController;


}
