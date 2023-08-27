package com.jopezin.pongclash.services;

import com.jopezin.pongclash.domain.Match;
import com.jopezin.pongclash.repositories.MatchRepository;
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
public class MatchService {
    @Autowired
    private MatchRepository repository;

    public Match findById(UUID id){
        Optional<Match> match = repository.findById(id);
        return match.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    public List<Match> findAll(){
        return repository.findAll();
    }

    public Match insert(Match match){
        return repository.save(match);
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
}
