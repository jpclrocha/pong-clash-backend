package com.jopezin.pongclash.controllers;

import com.jopezin.pongclash.domain.Match;
import com.jopezin.pongclash.domain.User;
import com.jopezin.pongclash.dto.MatchDTO;
import com.jopezin.pongclash.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/matches")
public class MatchController {

    @Autowired
    private MatchService service;

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches(){
        List<Match> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Match> getMatchById(UUID id){
        Match match = service.findById(id);
        return ResponseEntity.ok().body(match);
    }

    }
