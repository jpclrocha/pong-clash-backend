package com.jopezin.pongclash.services;

import com.jopezin.pongclash.domain.team.Team;
import com.jopezin.pongclash.domain.user.User;
import com.jopezin.pongclash.dto.TeamDTO;
import com.jopezin.pongclash.dto.UserDTO;
import com.jopezin.pongclash.repositories.TeamRepository;
import com.jopezin.pongclash.services.exceptions.DatabaseException;
import com.jopezin.pongclash.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public List<Team> findAll(){
        return repository.findAll();
    }

    public Team findById(UUID id){
        Optional<Team> team = repository.findById(id);
        return team.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    public Team findByName(String name){
        return repository.findByName(name);
    }

    public Team insert(Team team){
        return repository.save(team);
    }

    public void delete(UUID id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id.toString());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Team fromDTO(TeamDTO teamDTO) {
        Optional<Team> team = repository.findById(teamDTO.id());
        return team.orElseThrow(() -> new ResourceNotFoundException(teamDTO.id().toString()));
    }

    public List<User> getTeamMembers(UUID id) {
        Optional<Team> team = repository.findById(id);
        return team
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()))
                .getMembers();
    }
}
