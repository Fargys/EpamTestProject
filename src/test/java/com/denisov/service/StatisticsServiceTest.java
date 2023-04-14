package com.denisov.service;

import com.denisov.dto.ResultDTO;
import com.denisov.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statService;

    @Autowired
    private TeamService teamService;

    private static final int POINTS_FOR_WIN = 3;
    private static final int POINTS_FOR_LOSS = 0;
    private static final int ONE_VALUE = 1;
    private static final int ZERO_VALUE = 0;

    private static final String LOKOMOTIV_ID = "1";
    private static final String SPARTAK_ID = "2";
    private static final int LOKOMOTIV_GOALS = 2;
    private static final int SPARTAK_GOALS = 1;

    @Test
    void playGameTest() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setHomeTeamId(LOKOMOTIV_ID);
        resultDTO.setHomeGoals(LOKOMOTIV_GOALS);
        resultDTO.setGuestTeamId(SPARTAK_ID);
        resultDTO.setGuestGoals(SPARTAK_GOALS);

        statService.playGame(resultDTO);

        Team lokomotiv = teamService.findOne(LOKOMOTIV_ID);
        assertEquals(ONE_VALUE, lokomotiv.getGames());
        assertEquals(ONE_VALUE, lokomotiv.getWins());
        assertEquals(ZERO_VALUE, lokomotiv.getDraws());
        assertEquals(ZERO_VALUE, lokomotiv.getLosses());
        assertEquals(LOKOMOTIV_GOALS, lokomotiv.getScored());
        assertEquals(SPARTAK_GOALS, lokomotiv.getMissed());
        assertEquals(POINTS_FOR_WIN, lokomotiv.getPoints());

        Team spartak = teamService.findOne(SPARTAK_ID);
        assertEquals(ONE_VALUE, spartak.getGames());
        assertEquals(ZERO_VALUE, spartak.getWins());
        assertEquals(ZERO_VALUE, spartak.getDraws());
        assertEquals(ONE_VALUE, spartak.getLosses());
        assertEquals(SPARTAK_GOALS, spartak.getScored());
        assertEquals(LOKOMOTIV_GOALS, spartak.getMissed());
        assertEquals(POINTS_FOR_LOSS, spartak.getPoints());
    }
}
