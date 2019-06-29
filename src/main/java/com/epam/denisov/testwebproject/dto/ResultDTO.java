package com.epam.denisov.testwebproject.dto;

import org.springframework.stereotype.Component;

@Component
public class ResultDTO {
    String homeTeamId;
    String guestTeamId;
    int homeGoals;
    int guestGoals;

    public String getHomeTeamId() {
        return homeTeamId;
    }
    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }
    public String getGuestTeamId() {
        return guestTeamId;
    }
    public void setGuestTeamId(String guestTeamId) {
        this.guestTeamId = guestTeamId;
    }
    public int getHomeGoals() {
        return homeGoals;
    }
    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }
    public int getGuestGoals() {
        return guestGoals;
    }
    public void setGuestGoals(int guestGoals) {
        this.guestGoals = guestGoals;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "homeTeamId='" + homeTeamId + '\'' +
                ", guestTeamId='" + guestTeamId + '\'' +
                ", homeGoals=" + homeGoals +
                ", guestGoals=" + guestGoals +
                '}';
    }
}
