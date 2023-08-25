package com.jopezin.pongclash.services;

import com.jopezin.pongclash.domain.Team;
import com.jopezin.pongclash.domain.User;
import com.jopezin.pongclash.repositories.UserRepository;
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
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamService teamService;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(UUID id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(UUID id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id.toString());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User insertTeam(UUID userId, Team team){
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(userId.toString()));
        user.setTeam(team);

        return userRepository.save(user);
    }
}
