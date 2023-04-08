package com.denisov.service;

import com.denisov.dao.TeamDAO;
import com.denisov.model.Championship;
import com.denisov.repository.TeamRepository;
import com.denisov.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final ChampionshipService champService;
    private final TeamDAO teamDAO;

    @Autowired
    public TeamService(ChampionshipService championshipService, TeamDAO teamDAO) {
        this.champService = championshipService;
        this.teamDAO = teamDAO;
    }


    public Team findOne(String teamId) {
        Long currentId = Long.parseLong(teamId, 10);

        return teamDAO.findById(currentId).orElse(null);
    }

    public Team findByName(String name) {
        return teamDAO.findByName(name);
    }

    public List<Team> findAll(String champId) {
        Championship champ = champService.findOne(champId);
        return teamDAO.findAllByChampionship(champ);
    }

    public void save(TeamRepository teamRepository) {
        Championship champ = champService.findOne(teamRepository.getChampId());
        Team team = new Team();
        team.setValues(teamRepository, champ);
        teamDAO.save(team);
    }

    public void save(Team team) {
        teamDAO.save(team);
    }

    public void delete(String teamId) {
        Long id = Long.parseLong(teamId, 10);
        teamDAO.deleteById(id);
    }

     public void update(TeamRepository teamRepository) {
        Team team = this.findOne(teamRepository.getId());
        team.setValues(teamRepository, team.getChampionship());
        teamDAO.save(team);
    }
}
