package com.jopezin.pongclash.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Entity(name = "matches")
@Table(name = "matches")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Match implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    private User player1;
    private Integer player1Score;
    @OneToMany(mappedBy = "match")
    private List<Results> player1Results = new ArrayList<>();



    private User player2;
    private Integer player2Score;
    @OneToMany(mappedBy = "match")
    private List<Results> player2Results = new ArrayList<>();

    public Match(UUID id, User player1, User player2){

    }

}
