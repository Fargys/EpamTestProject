package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.TestWebProjectApplication;
import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestWebProjectApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
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