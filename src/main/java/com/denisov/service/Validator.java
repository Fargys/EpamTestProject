package com.denisov.service;

import com.denisov.model.Championship;
import com.denisov.repository.ChampionshipRepository;
import com.denisov.repository.ResultRepository;
import com.denisov.repository.TeamRepository;
import com.denisov.model.Team;
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

    public boolean champIsValid(ChampionshipRepository champDTO){
        Championship champ = champService.findByName(champDTO.getName());
        return champ == null;
    }

    public boolean teamIsValid(TeamRepository teamRepository){
        Championship champ = champService.findOne(teamRepository.getChampId());
        Team team = teamService.findByName(teamRepository.getName());
        return !champ.getParticipants().contains(team);
    }

    public boolean rivalsIsValid(ResultRepository resultRepository){
        return !resultRepository.getHomeTeamId().equals(resultRepository.getGuestTeamId());
    }
}
