package com.denisov.service;

import com.denisov.repository.TeamRepository;
import com.denisov.entity.Championship;
import com.denisov.dto.TeamDTO;
import com.denisov.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final ChampionshipService champService;
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(ChampionshipService championshipService, TeamRepository teamRepository) {
        this.champService = championshipService;
        this.teamRepository = teamRepository;
    }


    public Team findOne(String teamId) {
        Long currentId = Long.parseLong(teamId, 10);

        return teamRepository.findById(currentId).orElse(null);
    }

    public Team findByName(String name) {
        return teamRepository.findByName(name);
    }

    public List<Team> findAll(String champId) {
        Championship champ = champService.findOne(champId);
        return teamRepository.findAllByChampionship(champ);
    }

    public void save(TeamDTO teamDTO) {
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = new Team();
        team.setValues(teamDTO, champ);
        teamRepository.save(team);
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public void delete(String teamId) {
        Long id = Long.parseLong(teamId, 10);
        teamRepository.deleteById(id);
    }

    public Team update(TeamDTO teamDTO) {
        Team team = findOne(teamDTO.getId());
        team.setValues(teamDTO, team.getChampionship());

        return teamRepository.save(team);
    }
}
