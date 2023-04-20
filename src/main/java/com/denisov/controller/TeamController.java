package com.denisov.controller;

import com.denisov.service.StatisticsService;
import com.denisov.entity.Championship;
import com.denisov.service.ChampionshipService;
import com.denisov.service.TeamService;
import com.denisov.service.Validator;
import com.denisov.dto.ResultDTO;
import com.denisov.dto.TeamDTO;
import com.denisov.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

    private static final String TEAM_LIST_JSP  = "teamList";
    private static final String TEAM_ERROR_JSP = "teamError";
    private static final String EDIT_TEAM_JSP  = "editTeam";

    private static final String ATTR_CURRENT_CHAMPIONSHIP = "currentChampionship";
    private static final String ATTR_TEAMS                = "teams";
    private static final String ATTR_MESSAGE              = "message";
    private static final String ATTR_CURRENT_TEAM         = "currentTeam";

    private static final String TEAM_ERROR_MESSAGE = "Team already exists";
    private static final String PLAY_ERROR_MESSAGE = "You chose the same team";


    private final TeamService teamService;
    private final ChampionshipService champService;
    private final StatisticsService statService;
    private final Validator validator;

    @Autowired
    public TeamController(ChampionshipService champService, TeamService teamService
            , StatisticsService statService, Validator validator) {
        this.teamService = teamService;
        this.champService = champService;
        this.statService = statService;
        this.validator = validator;
    }

    @GetMapping(value = { "/list/{champId}" })
    public String list(Model model, @PathVariable("champId") String champId) {

        Championship currentChampionship = champService.findOne(champId);
        List<Team> teams = currentChampionship.getParticipants();

        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);
        model.addAttribute(ATTR_TEAMS, teams);

        return TEAM_LIST_JSP;
    }

    @PostMapping(value = "/create")
    public String save(@ModelAttribute TeamDTO teamDTO, Model model) {
        Championship currentChampionship;

        if(validator.teamIsValid(teamDTO)) {
            teamService.save(teamDTO);

            List<Team> teams = teamService.findAll(teamDTO.getChampId());
            currentChampionship = teams.get(0).getChampionship();

            model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);
            model.addAttribute(ATTR_TEAMS, teams);

            return TEAM_LIST_JSP;
        }

        currentChampionship = champService.findOne(teamDTO.getChampId());

        model.addAttribute(ATTR_MESSAGE, TEAM_ERROR_MESSAGE);
        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);

        return TEAM_ERROR_JSP;
    }

    @GetMapping(value = "/edit/{teamId}")
    public String edit(@PathVariable("teamId") String teamId, Model model) {
        Team currentTeam = teamService.findOne(teamId);
        Championship currentChampionship = currentTeam.getChampionship();

        model.addAttribute(ATTR_CURRENT_TEAM, currentTeam);
        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);

        return EDIT_TEAM_JSP;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute TeamDTO teamDTO, Model model) {
        Championship currentChampionship;

        if(validator.updateTeamIsValid(teamDTO)) {
            teamService.update(teamDTO);

            List<Team> teams = teamService.findAll(teamDTO.getChampId());
            currentChampionship = teams.get(0).getChampionship();

            model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);
            model.addAttribute(TeamController.ATTR_TEAMS, teams);

            return TEAM_LIST_JSP;
        }

        currentChampionship = champService.findOne(teamDTO.getChampId());

        model.addAttribute(ATTR_MESSAGE, TEAM_ERROR_MESSAGE);
        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);

        return TEAM_ERROR_JSP;
    }

    @GetMapping(value = "/delete/{teamId}")
    public String delete(Model model, @PathVariable("teamId") String teamId) {
        Team team = teamService.findOne(teamId);
        Long champId = team.getChampionship().getId();

        teamService.delete(teamId);

        Championship currentChampionship = champService.findOne(champId);
        List<Team> teams = currentChampionship.getParticipants();

        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);
        model.addAttribute(ATTR_TEAMS, teams);

        return TEAM_LIST_JSP;
    }

    @PostMapping(value = "play")
    public String play(@ModelAttribute("result") ResultDTO resultDTO, Model model) {
        Championship currentChampionship;

        if(validator.rivalsIsValid(resultDTO)) {
            statService.playGame(resultDTO);

            currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();
            List<Team> teams = currentChampionship.getParticipants();

            model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);
            model.addAttribute(ATTR_TEAMS, teams);

            return TEAM_LIST_JSP;
        }

        currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();

        model.addAttribute(ATTR_MESSAGE, PLAY_ERROR_MESSAGE);
        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);

        return TEAM_ERROR_JSP;
    }
}
