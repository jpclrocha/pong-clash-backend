package com.jopezin.pongclash.services;

import com.jopezin.pongclash.domain.Tournament;
import com.jopezin.pongclash.repositories.TournamentRepository;
import com.jopezin.pongclash.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository repository;

    public List<Tournament> findAll(){
        return repository.findAll();
    }

    public Tournament findById(UUID id){
        Optional<Tournament> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    public Tournament insert(Tournament tournament){
        return repository.save(tournament);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }


}
