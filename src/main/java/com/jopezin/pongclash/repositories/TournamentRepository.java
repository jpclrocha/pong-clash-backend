package com.jopezin.pongclash.repositories;

import com.jopezin.pongclash.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TournamentRepository extends JpaRepository<Tournament, UUID> {
}
