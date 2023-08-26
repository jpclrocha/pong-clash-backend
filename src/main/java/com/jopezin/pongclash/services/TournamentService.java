package com.jopezin.pongclash.services;

import com.jopezin.pongclash.domain.Tournament;
import com.jopezin.pongclash.domain.User;
import com.jopezin.pongclash.domain.UserTournaments;
import com.jopezin.pongclash.domain.enums.Category;
import com.jopezin.pongclash.dto.EnterTournamentDTO;
import com.jopezin.pongclash.repositories.TournamentRepository;
import com.jopezin.pongclash.repositories.UserTournamentsRepository;
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

    @Autowired
    private UserTournamentsRepository userTournamentsRepository;

    @Autowired
    private UserService userService;

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


    public Tournament insertPlayer(UUID id, EnterTournamentDTO obj) {
        Tournament tournament = repository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException(id.toString()));

        User user = userService.findById(obj.userId());

        UserTournaments userTournaments = new UserTournaments(tournament,
                                                              user,
                                                              Category.valueOf(obj.category()));

        tournament.getPlayers().add(userTournaments);

        userTournamentsRepository.save(userTournaments);

        return tournament;
    }
}
