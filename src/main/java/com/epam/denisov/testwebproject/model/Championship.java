package com.epam.denisov.testwebproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

import static java.util.Collections.*;

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
    private List<Team> participants;

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
    public List<Team> getParticipants() {
        if(participants == null) participants = new ArrayList<>();
        sort(participants);
        return participants;
    }
    public void setParticipants(List<Team> participants) {
        this.participants = participants;
    }
}
