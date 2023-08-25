package com.jopezin.pongclash.repositories;

import com.jopezin.pongclash.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    Team findByName(String name);
}
