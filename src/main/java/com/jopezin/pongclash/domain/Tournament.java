package com.jopezin.pongclash.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jopezin.pongclash.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Entity(name = "tournaments")
@Table(name = "tournaments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Tournament implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private UUID teamId;

    @OneToMany(mappedBy = "id.tournament")
    @JsonIgnore
    private List<UserTournaments> players = new ArrayList<>();

    @OneToMany(mappedBy = "tournament")
    private List<Match> matches = new ArrayList<>();

    public Tournament(UUID id, String name, UUID teamId){
        setId(id);
        setName(name);
        setTeamId(teamId);
    }
}
