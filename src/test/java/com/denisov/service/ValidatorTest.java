package com.denisov.service;

import com.denisov.dto.ChampionshipDTO;
import com.denisov.dto.ResultDTO;
import com.denisov.dto.TeamDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ValidatorTest {

    private static final String RUSSIA_NAME = "Russia";
    private static final String RUSSIA_ID = "1";
    private static final String RUSSIA_NEW_NAME = "RF";

    private static final String LOKOMOTIV_ID = "1";
    private static final String LOKOMOTIV_NAME = "Lokomotiv";
    private static final String LOKOMOTIV_NEW_NAME = "Loko";
    private static final String ENGLAND_NAME = "England";
    private static final String SPARTAK_NAME = "Spartak";

    @Autowired
    private Validator validator;

    private static final String VALID_CHAMPIONSHIP_NAME = "missing in database";
    private static final String INVALID_CHAMPIONSHIP_NAME = "England";

    private static final String VALID_TEAM_NAME = "missing in database";
    private static final String INVALID_TEAM_NAME = "Spartak";
    private static final String VALID_CHAMPIONSHIP_ID = "1";

    private static final String FIRST_TEAM_VALID_ID = "1";
    private static final String SECOND_TEAM_VALID_ID = "2";

    @Test
    void champIsValidPositiveTest() {
        ChampionshipDTO validChamp = new ChampionshipDTO();
        validChamp.setName(VALID_CHAMPIONSHIP_NAME);

        assertTrue(validator.champIsValid(validChamp));
    }

    @Test
    void champIsValidNegativeTest() {
        ChampionshipDTO invalidChamp = new ChampionshipDTO();
        invalidChamp.setName(INVALID_CHAMPIONSHIP_NAME);

        assertFalse(validator.champIsValid(invalidChamp));
    }

    @Test
    void updateChampIsValidPositiveTest() {
        ChampionshipDTO validChamp = new ChampionshipDTO();
        validChamp.setId(RUSSIA_ID);
        validChamp.setName(RUSSIA_NAME);

        assertTrue(validator.updateChampIsValid(validChamp));
    }

    @Test
    void updateChampIsValidPositiveTest2() {
        ChampionshipDTO validChamp = new ChampionshipDTO();
        validChamp.setId(RUSSIA_ID);
        validChamp.setName(RUSSIA_NEW_NAME);

        assertTrue(validator.updateChampIsValid(validChamp));
    }

    @Test
    void updateChampIsValidNegativeTest() {
        ChampionshipDTO validChamp = new ChampionshipDTO();
        validChamp.setId(RUSSIA_ID);
        validChamp.setName(ENGLAND_NAME);

        assertFalse(validator.updateChampIsValid(validChamp));
    }

    @Test
    void teamIsValidPositiveTest() {
        TeamDTO validTeam = new TeamDTO();
        validTeam.setName(VALID_TEAM_NAME);
        validTeam.setChampId(VALID_CHAMPIONSHIP_ID);

        assertTrue(validator.teamIsValid(validTeam));
    }

    @Test
    void teamIsValidNegativeTest() {
        TeamDTO invalidTeam = new TeamDTO();
        invalidTeam.setName(INVALID_TEAM_NAME);
        invalidTeam.setChampId(VALID_CHAMPIONSHIP_ID);

        assertFalse(validator.teamIsValid(invalidTeam));
    }

    @Test
    void updateTeamIsValidPositiveTest() {
        TeamDTO validTeam = new TeamDTO();
        validTeam.setId(LOKOMOTIV_ID);
        validTeam.setName(LOKOMOTIV_NAME);
        validTeam.setChampId(RUSSIA_ID);

        assertTrue(validator.updateTeamIsValid(validTeam));
    }

    @Test
    void updateTeamIsValidPositiveTest2() {
        TeamDTO validTeam = new TeamDTO();
        validTeam.setId(LOKOMOTIV_ID);
        validTeam.setName(LOKOMOTIV_NEW_NAME);
        validTeam.setChampId(RUSSIA_ID);

        assertTrue(validator.updateTeamIsValid(validTeam));
    }

    @Test
    void updateTeamIsValidNegativeTest() {
        TeamDTO invalidTeam = new TeamDTO();
        invalidTeam.setId(LOKOMOTIV_ID);
        invalidTeam.setName(SPARTAK_NAME);
        invalidTeam.setChampId(RUSSIA_ID);

        assertFalse(validator.updateTeamIsValid(invalidTeam));
    }

    @Test
    void rivalsIsValidPositiveTest() {
        ResultDTO validResultDTO = new ResultDTO();
        validResultDTO.setHomeTeamId(FIRST_TEAM_VALID_ID);
        validResultDTO.setGuestTeamId(SECOND_TEAM_VALID_ID);

        assertTrue(validator.rivalsIsValid(validResultDTO));
    }

    @Test
    void rivalsIsValidNegativeTest() {
        ResultDTO invalidResultDTO = new ResultDTO();
        invalidResultDTO.setHomeTeamId(FIRST_TEAM_VALID_ID);
        invalidResultDTO.setGuestTeamId(FIRST_TEAM_VALID_ID);

        assertFalse(validator.rivalsIsValid(invalidResultDTO));
    }
}
