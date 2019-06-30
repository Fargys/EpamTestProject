package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.Repository.TeamRepository;
import com.epam.denisov.testwebproject.dto.TeamDTO;
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

    public void delete(String teamId) {
        Long id = Long.parseLong(teamId, 10);
        teamRepository.delete(id);
    }

    public void save(TeamDTO teamDTO) {
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = new Team();
        team.setValues(teamDTO, champ);
        teamRepository.save(team);
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

     public void update(TeamDTO teamDTO) {
        Team team = this.findOne(teamDTO.getId());
        team.setValues(teamDTO, team.getChampionship());
        teamRepository.save(team);
    }

    public boolean hasTeam(TeamDTO teamDTO) {
        Championship champ = champService.findOne(teamDTO.getChampId());
        Team team = teamRepository.findByName(teamDTO.getName());
        return champ.getParticipants().contains(team);
    }

    public List<Team> findAll(String champId) {
        Championship champ = champService.findOne(champId);
        return teamRepository.findAllByChampionship(champ);
    }
}
