package com.denisov.service;

import com.denisov.entity.Championship;
import com.denisov.dto.ChampionshipDTO;
import com.denisov.dto.ResultDTO;
import com.denisov.dto.TeamDTO;
import com.denisov.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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


    public boolean updateChampIsValid(ChampionshipDTO champDTO) {
        Championship champ = champService.findByName(champDTO.getName());
        if (champ == null) return true;

        return champ.getId().toString().equals(champDTO.getId());
    }

    @Transactional
    public boolean teamIsValid(TeamDTO teamDTO){
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = teamService.findByName(teamDTO.getName());
        return !champ.getParticipants().contains(team);
    }

    @Transactional
    public boolean updateTeamIsValid(TeamDTO teamDTO) {
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = teamService.findByName(teamDTO.getName());
        if(team == null) return true;

        return champ.getParticipants().stream()
                .anyMatch(t -> team.getId().toString().equals(teamDTO.getId()));
    }

    public boolean rivalsIsValid(ResultDTO resultDTO){
        return !resultDTO.getHomeTeamId().equals(resultDTO.getGuestTeamId());
    }
}
