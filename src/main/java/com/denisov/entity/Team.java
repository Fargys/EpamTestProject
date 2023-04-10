package com.denisov.entity;

import com.denisov.dto.TeamDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team implements Comparable<Team>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version = 0;

    @NotNull
    private String name;

    @Column(name = "games")
    private Integer games = 0;

    @Column(name = "wins")
    private Integer wins = 0;

    @Column(name = "draws")
    private Integer draws = 0;

    @Column(name = "losses")
    private Integer losses = 0;

    @Column(name = "scored")
    private Integer scored = 0;

    @Column(name = "missed")
    private Integer missed = 0;

    @Column(name = "points")
    private Integer points = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "champ_id")
    private Championship championship;


    public void setValues(TeamDTO teamDTO, Championship champ) {
        if(teamDTO.getId() != null) this.id = Long.parseLong(teamDTO.getId(), 10);
        if(teamDTO.getName() != null) this.name = teamDTO.getName();
        if(teamDTO.getGames() != null) this.games = Integer.parseInt(teamDTO.getGames());
        if(teamDTO.getWins() != null) this.wins = Integer.parseInt(teamDTO.getWins());
        if(teamDTO.getDraws() != null) this.draws = Integer.parseInt(teamDTO.getDraws());
        if(teamDTO.getLosses() != null) this.losses = Integer.parseInt(teamDTO.getLosses());
        if(teamDTO.getScored() != null) this.scored = Integer.parseInt(teamDTO.getScored());
        if(teamDTO.getMissed() != null) this.missed = Integer.parseInt(teamDTO.getMissed());
        if(teamDTO.getPoints() != null) this.points = Integer.parseInt(teamDTO.getPoints());
        if(champ != null) this.championship = champ;
    }

    @Override
    public int compareTo(Team team) {
        if(this.points > team.points) return -1;
        else if(this.points < team.points) return 1;

        if(this.wins > team.wins) return -1;
        else if(this.wins < team.wins) return 1;


        int thisDifference = this.scored - this.missed;
        int teamDifference = team.scored - team.missed;

        if(thisDifference > teamDifference) return -1;
        else if(thisDifference < teamDifference) return 1;

        if(this.scored > team.scored) return -1;
        else if(this.scored < team.scored) return 1;

        if(this.games < team.games) return -1;
        else if(this.games > team.games) return 1;

        return 0;
    }
}
