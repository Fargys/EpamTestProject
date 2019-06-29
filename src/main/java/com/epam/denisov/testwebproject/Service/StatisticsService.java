package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.dto.ResultDTO;
import com.epam.denisov.testwebproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private static final int POINTS_FOR_WIN = 3;
    private static final int POINTS_FOR_DRAW = 1;
    private static final int POINTS_FOR_LOSS = 0;
    private static final int ONE_VALUE = 1;

    private final TeamService teamService;

    @Autowired
    public StatisticsService(TeamService teamService) {
        this.teamService = teamService;
    }

    public void playGame(ResultDTO resultDTO) {
        Team homeTeam = teamService.findOne(resultDTO.getHomeTeamId());
        Team guestTeam = teamService.findOne(resultDTO.getGuestTeamId());
        int homeGoals = resultDTO.getHomeGoals();
        int guestGoals= resultDTO.getGuestGoals();

        homeTeam.setGames(homeTeam.getGames() + ONE_VALUE);
        guestTeam.setGames(guestTeam.getGames() + ONE_VALUE);

        switch(getWinner(homeGoals, guestGoals)) {

            case HOME_TEAM:
                win(homeTeam, homeGoals, guestGoals);
                loss(guestTeam, guestGoals, homeGoals);
                break;

            case GUEST_TEAM:
                win(guestTeam, guestGoals, homeGoals);
                loss(homeTeam, homeGoals, guestGoals);
                break;

            case NO_ONE:
                draw(homeTeam, homeGoals, guestGoals);
                draw(guestTeam, guestGoals, homeGoals);
                break;

            default:
                throw new IllegalArgumentException();
        }

        teamService.save(homeTeam);
        teamService.save(guestTeam);
    }

    private Winner getWinner(int homeGoals, int guestGoals) {
        if(homeGoals > guestGoals) return Winner.HOME_TEAM;
        else if(homeGoals < guestGoals) return Winner.GUEST_TEAM;
        else return Winner.NO_ONE;
    }

    private void win(Team winner, int winnerScored, int winnerMissed) {
        winner.setWins(winner.getWins() + ONE_VALUE);
        winner.setScored(winner.getScored() + winnerScored);
        winner.setMissed(winner.getMissed() + winnerMissed);
        winner.setPoints(winner.getPoints() + POINTS_FOR_WIN);
    }

    private void loss(Team looser, int looserScored, int looserMissed) {
        looser.setLosses(looser.getLosses() + ONE_VALUE);
        looser.setScored(looser.getScored() + looserScored);
        looser.setMissed(looser.getMissed() + looserMissed);
        looser.setPoints(looser.getPoints() + POINTS_FOR_LOSS);
    }

    private void draw(Team team, int teamScored, int teamMissed) {
        team.setDraws(team.getDraws() + ONE_VALUE);
        team.setScored(team.getScored() + teamScored);
        team.setMissed(team.getMissed() + teamMissed);
        team.setPoints(team.getPoints() + POINTS_FOR_DRAW);
    }

    public enum Winner {
        HOME_TEAM,
        GUEST_TEAM,
        NO_ONE
    }
}
