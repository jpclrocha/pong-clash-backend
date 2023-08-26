package com.jopezin.pongclash.controllers;

import com.jopezin.pongclash.domain.Tournament;
import com.jopezin.pongclash.domain.UserTournaments;
import com.jopezin.pongclash.domain.pk.UserTournamentsPK;
import com.jopezin.pongclash.dto.CreateTournamentDTO;
import com.jopezin.pongclash.dto.EnterTournamentDTO;
import com.jopezin.pongclash.dto.UserDTO;
import com.jopezin.pongclash.services.TournamentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @GetMapping
    public ResponseEntity<List<Tournament>> findAllTournaments(){
        List<Tournament> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tournament> findById(@PathVariable UUID id){
        Tournament obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Tournament> insert(@RequestBody CreateTournamentDTO obj){
        Tournament t = new Tournament(UUID.randomUUID(), obj.name(), obj.teamId());
        t = service.insert(t);
        return ResponseEntity.ok().body(t);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/players")
    public ResponseEntity<List<UserDTO>> getPlayers(@PathVariable UUID id){
        List<UserDTO> list = service.findById(id)
                                    .getPlayers()
                                    .stream()
                                    .map(x -> new UserDTO(x.getId().getUser().getFirstname(),
                                                          x.getId().getUser().getLastname(),
                                                          x.getId().getUser().getEmail()))
                                    .collect(Collectors.toList());

        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}/players")
    public ResponseEntity<Tournament> insertPlayer(@PathVariable UUID id,
                                                   @RequestBody EnterTournamentDTO obj){
        Tournament tournament = service.insertPlayer(id, obj);
        return ResponseEntity.ok().body(tournament);
    }
}
