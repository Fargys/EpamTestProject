package com.denisov.model;

import com.denisov.repository.TeamRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "team")
public class Team implements Comparable, Serializable {

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


    //Constructors
    public Team() {
    }
    public Team(String teamName) {
        this.name = teamName;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getGames() {
        return games;
    }
    public void setGames(Integer games) {
        this.games = games;
    }
    public Integer getWins() {
        return wins;
    }
    public void setWins(Integer wins) {
        this.wins = wins;
    }
    public Integer getDraws() {
        return draws;
    }
    public void setDraws(Integer draws) {
        this.draws = draws;
    }
    public Integer getLosses() {
        return losses;
    }
    public void setLosses(Integer losses) {
        this.losses = losses;
    }
    public Integer getScored() {
        return scored;
    }
    public void setScored(Integer scored) {
        this.scored = scored;
    }
    public Integer getMissed() {
        return missed;
    }
    public void setMissed(Integer missed) {
        this.missed = missed;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public Championship getChampionship() {
        return championship;
    }
    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public void setValues(TeamRepository teamRepository, Championship champ) {
        if(teamRepository.getId() != null) this.id = Long.parseLong(teamRepository.getId(), 10);
        if(teamRepository.getName() != null) this.name = teamRepository.getName();
        if(teamRepository.getGames() != null) this.games = Integer.parseInt(teamRepository.getGames());
        if(teamRepository.getWins() != null) this.wins = Integer.parseInt(teamRepository.getWins());
        if(teamRepository.getDraws() != null) this.draws = Integer.parseInt(teamRepository.getDraws());
        if(teamRepository.getLosses() != null) this.losses = Integer.parseInt(teamRepository.getLosses());
        if(teamRepository.getScored() != null) this.scored = Integer.parseInt(teamRepository.getScored());
        if(teamRepository.getMissed() != null) this.missed = Integer.parseInt(teamRepository.getMissed());
        if(teamRepository.getPoints() != null) this.points = Integer.parseInt(teamRepository.getPoints());
        if(champ != null) this.championship = champ;
    }

    @Override
    public int compareTo(Object o) {
        Team team = (Team) o;

        if(this.points > team.points) return -1;
        else if(this.points < team.points) return 1;

        if(this.wins > team.wins) return -1;
        else if(this.wins < team.wins) return 1;


        int thisDifference = this.scored - this.missed;
        int teamDifference = team.scored - team.missed;

        if(thisDifference > teamDifference) return -1;
        else if(thisDifference < teamDifference) return 1;

        if(this.games < team.games) return -1;
        else if(this.games > team.games) return 1;

        return 0;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
