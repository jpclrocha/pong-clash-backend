package com.jopezin.pongclash.domain;

import com.jopezin.pongclash.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Entity(name = "tournaments")
@Table(name = "tournaments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tournament implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private UUID team_id;

    @OneToMany(mappedBy = "tournament")
    private List<UserTournaments> players = new ArrayList<>();
}
