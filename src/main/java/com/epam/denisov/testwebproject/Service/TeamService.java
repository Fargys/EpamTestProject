package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.Repository.TeamRepository;
import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
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

        return teamRepository.findOne(currentId);
    }

    public List<Team> findAll(String champId) {
        return null;
    }

    public void delete(String teamId) {
        Long id = Long.parseLong(teamId, 10);
        teamRepository.delete(id);
    }

    public void save(String teamName, String champId) {
        Team newTeam = new Team(teamName);
        newTeam.setChampionship(champService.findOne(champId));
        teamRepository.save(newTeam);
    }

    public void update(String teamId, String newName) {
        Team team = this.findOne(teamId);
        team.setName(newName);
        teamRepository.save(team);
    }
}
