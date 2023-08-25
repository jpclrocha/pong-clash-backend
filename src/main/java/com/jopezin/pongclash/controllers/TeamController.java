package com.jopezin.pongclash.controllers;

import com.jopezin.pongclash.domain.Team;
import com.jopezin.pongclash.domain.User;
import com.jopezin.pongclash.dto.CreateTeamDTO;
import com.jopezin.pongclash.dto.UserDTO;
import com.jopezin.pongclash.services.TeamService;
import com.jopezin.pongclash.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

    @Autowired
    private TeamService service;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable UUID id){
        Team team = service.findById(id);
        return ResponseEntity.ok().body(team);
    }

    @PostMapping
    public ResponseEntity<Team> insertTeam(@RequestBody CreateTeamDTO obj){
        if(service.findByName(obj.name()) != null) throw new RuntimeException("Time ja existe");
        User user = userService.findById(obj.ownerId());
        Team team = new Team(UUID.randomUUID(),
                             obj.name(),
                             obj.acronym(),
                             user);
        team = service.insert(team);

        userService.insertTeam(obj.ownerId(), team);

        return ResponseEntity.ok().body(team);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/members")
    public ResponseEntity<List<UserDTO>> getTeamMembers(@PathVariable UUID id){
        List<UserDTO> list = service.getTeamMembers(id)
                                    .stream()
                                    .map(x -> new UserDTO(
                                            x.getFirstname(),
                                            x.getLastname(),
                                            x.getEmail()))
                                    .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
}
