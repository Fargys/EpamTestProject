package com.epam.denisov.testwebproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "championship")
public class Championship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version = 0;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "championship", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Team> participants;

    // Constructors
    public Championship() {
    }
    public Championship(String name) {
        this.name = name;
    }

    // Setters and getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Team> getParticipants() {
        if(participants == null) participants = new HashSet<>();
        return participants;
    }
    public void setParticipants(Set<Team> participants) {
        this.participants = participants;
    }
}
