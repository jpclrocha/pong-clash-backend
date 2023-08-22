package com.jopezin.pongclash.repositories;

import com.jopezin.pongclash.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
