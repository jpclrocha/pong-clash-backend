package com.jopezin.pongclash.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "teams")
@Table(name = "teams")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String acronym;

   @Lob
    private User founder;

    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<User> members = new ArrayList<>();

    public Team(UUID id, String name, String acronym, User founder) {
        setId(id);
        setName(name);
        setAcronym(acronym);
        setFounder(founder);
    }

    public void setMembers(User user) {
        this.members.add(user);
    }

}
