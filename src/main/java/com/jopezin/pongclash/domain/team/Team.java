package com.jopezin.pongclash.domain.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jopezin.pongclash.domain.user.User;
import com.jopezin.pongclash.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
