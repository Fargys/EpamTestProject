package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.dto.ChampionshipDTO;
import com.epam.denisov.testwebproject.dto.ResultDTO;
import com.epam.denisov.testwebproject.dto.TeamDTO;
import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Validator {

    private final ChampionshipService champService;
    private final TeamService teamService;

    @Autowired
    public Validator(ChampionshipService champService, TeamService teamService) {
        this.champService = champService;
        this.teamService = teamService;
    }

    public boolean champIsValid(ChampionshipDTO champDTO){
        Championship champ = champService.findByName(champDTO.getName());
        return champ == null;
    }

    public boolean teamIsValid(TeamDTO teamDTO){
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = teamService.findByName(teamDTO.getName());
        return !champ.getParticipants().contains(team);
    }

    public boolean rivalsIsValid(ResultDTO resultDTO){
        return !resultDTO.getHomeTeamId().equals(resultDTO.getGuestTeamId());
    }
}
