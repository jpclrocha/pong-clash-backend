package com.jopezin.pongclash.repositories;

import com.jopezin.pongclash.domain.UserTournaments;
import com.jopezin.pongclash.domain.pk.UserTournamentsPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTournamentsRepository extends JpaRepository<UserTournaments, UserTournamentsPK> {
}
