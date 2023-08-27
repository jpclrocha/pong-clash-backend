package com.jopezin.pongclash.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "results")
@Table(name = "results")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Results implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne @JoinColumn(name = "match_id")
    private Match match;

    @ManyToOne @JoinColumn(name = "user_id")
    private User player;

    private String setNumber;
    private int points;
}
