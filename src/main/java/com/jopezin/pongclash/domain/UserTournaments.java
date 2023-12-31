package com.jopezin.pongclash.domain;


import com.jopezin.pongclash.domain.enums.Category;
import com.jopezin.pongclash.domain.pk.UserTournamentsPK;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "users_tournaments")
@Table(name = "users_tournament")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class UserTournaments implements Serializable {

    @EmbeddedId
    private UserTournamentsPK id = new UserTournamentsPK();

    @Enumerated(EnumType.ORDINAL)
    private Category category;

    public UserTournaments(Tournament tournament, User user, Category category){
        setCategory(category);
        id.setTournament(tournament);
        id.setUser(user);
    }
}
