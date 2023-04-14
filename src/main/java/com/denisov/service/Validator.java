package com.denisov.service;

import com.denisov.entity.Championship;
import com.denisov.dto.ChampionshipDTO;
import com.denisov.dto.ResultDTO;
import com.denisov.dto.TeamDTO;
import com.denisov.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Transactional
    public boolean teamIsValid(TeamDTO teamDTO){
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = teamService.findByName(teamDTO.getName());
        return !champ.getParticipants().contains(team);
    }

    public boolean rivalsIsValid(ResultDTO resultDTO){
        return !resultDTO.getHomeTeamId().equals(resultDTO.getGuestTeamId());
    }
}
