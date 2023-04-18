package com.denisov.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

import static java.util.Collections.sort;


@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "championship")
    private List<Team> participants;

    public Championship(String name) {
        this.name = name;
    }

    public List<Team> getParticipants() {
        if(participants != null)
            sort(participants);

        return participants;
    }
}
