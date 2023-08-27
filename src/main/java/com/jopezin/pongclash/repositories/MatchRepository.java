package com.jopezin.pongclash.repositories;

import com.jopezin.pongclash.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
}
