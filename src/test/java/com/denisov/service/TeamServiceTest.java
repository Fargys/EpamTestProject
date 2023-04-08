package com.denisov.service;

import com.denisov.service.ChampionshipService;
import com.denisov.service.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamServiceTest {
    @Autowired
    private TeamService teamService;
    @Autowired
    private ChampionshipService champService;

    @Test
    public void findOne() {
//        String lokoId = "1";
//        Team team  = teamService.findOne(lokoId);
//        Assert.assertNotNull(team);
//        Assert.assertEquals("Lokomotiv", team.getName());
    }

    @Test
    public void delete() {
//        String lokoId = "1";
//        Team team = teamService.findOne(lokoId);
//        Assert.assertNotNull(team);
//
//        teamService.delete(lokoId);
//
//        team = teamService.findOne(lokoId);
//        Assert.assertNull(team);
    }

    @Test
    public void save() {
//        String russiaId = "1";
//        String newTeamName = "newTeam";
//
//        teamService.save(newTeamName, russiaId);
//
//        Championship champ = champService.findOne(russiaId);
//
//        int expectedSize = 5;
//        int actualSize = champ.getParticipants().size();
//        Assert.assertEquals(expectedSize, actualSize);
    }
}