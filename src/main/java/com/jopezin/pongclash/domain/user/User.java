package com.jopezin.pongclash.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
//    private Team team;
//    private List<Tournament> tournamentsPlayed;

//    public User(UUID id, String firstname, String lastname, String email, String password){
//        setId(id);
//        setFirstname(firstname);
//        setLastname(lastname);
//        setEmail(email);
//        setPassword(password);
//    }
}
