package com.denisov.service;

import com.denisov.dto.TeamDTO;
import com.denisov.entity.Championship;
import com.denisov.entity.Team;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ChampionshipService champService;

    private static final String RUSSIA_CHAMP_ID = "1";
    private static final Integer RUSSIA_PARTICIPANTS_COUNT = 4;
    private static final String LOKOMOTIV_ID = "1";
    private static final String LOKOMOTIV = "Lokomotiv";
    private static final String NEW_TEAM = "new Team";
    private static final String NEW_TEAM_TWO = "new Team two";
    private static final String UPDATE_NEW_TEAM_NAME = "update Team";


    @Test
    @Order(1)
    void findOneTest() {
        Team team  = teamService.findOne(LOKOMOTIV_ID);

        assertNotNull(team);
        assertEquals(LOKOMOTIV, team.getName());
    }

    @Test
    @Order(2)
    void findByNameTest() {
        Team team  = teamService.findByName(LOKOMOTIV);

        assertNotNull(team);
        assertEquals(LOKOMOTIV, team.getName());
    }

    @Test
    @Order(3)
    void findAllTest() {
        List<Team> russiaChamp = teamService.findAll(RUSSIA_CHAMP_ID);
        int actualCount = russiaChamp.size();

        assertNotNull(russiaChamp);
        assertEquals(RUSSIA_PARTICIPANTS_COUNT, actualCount);
    }

    @Test
    @Order(4)
    void saveDtoTest() {
        TeamDTO newTeamDTO = new TeamDTO();
        newTeamDTO.setName(NEW_TEAM);
        newTeamDTO.setChampId(RUSSIA_CHAMP_ID);

        teamService.save(newTeamDTO);

        Team newTeam = teamService.findByName(NEW_TEAM);
        assertNotNull(newTeam);
        assertNotNull(newTeam.getId());
    }

    @Test
    @Order(5)
    void saveEntityTest() {
        Championship russia = champService.findOne(RUSSIA_CHAMP_ID);

        Team newTeam = new Team();
        newTeam.setName(NEW_TEAM_TWO);
        newTeam.setChampionship(russia);

        newTeam = teamService.save(newTeam);

        teamService.findByName(NEW_TEAM_TWO);
        assertNotNull(newTeam);
        assertNotNull(newTeam.getId());
    }

    @Test
    @Order(6)
    void updateTest() {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(teamService.findByName(NEW_TEAM).getId().toString());
        teamDTO.setName(UPDATE_NEW_TEAM_NAME);

        Team team = teamService.update(teamDTO);
        assertNotNull(team.getId().toString());
        assertEquals(UPDATE_NEW_TEAM_NAME, team.getName());
    }

    @Order(7)
    @Test
    void deleteTest() {
        String id = teamService.findByName(UPDATE_NEW_TEAM_NAME).getId().toString();

        Team team = teamService.findOne(id);
        assertNotNull(team);

        teamService.delete(id);

        team = teamService.findOne(id);
        assertNull(team);
    }
}