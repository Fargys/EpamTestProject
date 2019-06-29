package com.epam.denisov.testwebproject.dto;

import org.springframework.stereotype.Component;

@Component
public class TeamDTO {
    private String id;
    private String name;
    private String games;
    private String wins;
    private String draws;
    private String losses;
    private String scored;
    private String missed;
    private String points;
    private String champId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGames() {
        return games;
    }
    public void setGames(String games) {
        this.games = games;
    }
    public String getWins() {
        return wins;
    }
    public void setWins(String wins) {
        this.wins = wins;
    }
    public String getDraws() {
        return draws;
    }
    public void setDraws(String draws) {
        this.draws = draws;
    }
    public String getLosses() {
        return losses;
    }
    public void setLosses(String losses) {
        this.losses = losses;
    }
    public String getScored() {
        return scored;
    }
    public void setScored(String scored) {
        this.scored = scored;
    }
    public String getMissed() {
        return missed;
    }
    public void setMissed(String missed) {
        this.missed = missed;
    }
    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }
    public String getChampId() {
        return champId;
    }
    public void setChampId(String champId) {
        this.champId = champId;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", games='" + games + '\'' +
                ", wins='" + wins + '\'' +
                ", draws='" + draws + '\'' +
                ", losses='" + losses + '\'' +
                ", scored='" + scored + '\'' +
                ", missed='" + missed + '\'' +
                ", points='" + points + '\'' +
                ", champId='" + champId + '\'' +
                '}';
    }
}
