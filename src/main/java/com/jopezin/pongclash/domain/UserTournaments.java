package com.jopezin.pongclash.domain;


import com.jopezin.pongclash.domain.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity(name = "users_tournaments")
@Table(name = "users_tournament")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserTournaments implements Serializable {

    @ManyToOne @Id
    private Tournament tournament;

    @ManyToOne @Id
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private Category category;
}
