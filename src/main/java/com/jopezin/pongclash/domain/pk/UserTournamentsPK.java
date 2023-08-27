package com.jopezin.pongclash.domain.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jopezin.pongclash.domain.Tournament;
import com.jopezin.pongclash.domain.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode()
public class UserTournamentsPK {

    @ManyToOne @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToOne @JoinColumn(name = "user_id") @JsonIgnore
    private User user;
}
