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

    @RequestMapping(value = { "/list/{champId}" }, method = RequestMethod.GET)
    public String list(Model model, @PathVariable("champId") String champId) {

        Championship currentChampionship = champService.findOne(champId);
        List<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }

    @RequestMapping(value = "/delete/{teamId}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("teamId") String teamId) {
        Team team = teamService.findOne(teamId);
        Long champId = team.getChampionship().getId();

        teamService.delete(teamId);

        Championship currentChampionship = champService.findOne(champId);
        List<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@ModelAttribute TeamDTO teamDTO, Model model) {
        Championship currentChampionship;

        if(validator.teamIsValid(teamDTO)) {
            teamService.save(teamDTO);

            List<Team> teams = teamService.findAll(teamDTO.getChampId());
            currentChampionship = teams.get(0).getChampionship();

            model.addAttribute("currentChampionship", currentChampionship);
            model.addAttribute("teams", teams);

            return "teamList";
        }

        String message = "Team already exists";
        currentChampionship = champService.findOne(teamDTO.getChampId());

        model.addAttribute("message", message);
        model.addAttribute("currentChampionship", currentChampionship);

        return "teamError";
    }

    @RequestMapping(value = "/edit/{teamId}", method = RequestMethod.GET)
    public String edit(@PathVariable("teamId") String teamId, Model model) {
        Team currentTeam = teamService.findOne(teamId);
        Championship currentChampionship = currentTeam.getChampionship();

        model.addAttribute("currentTeam", currentTeam);
        model.addAttribute("currentChampionship", currentChampionship);

        return "editTeam";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute TeamDTO teamDTO, Model model) {
        Championship currentChampionship;

        if(validator.teamIsValid(teamDTO)) {
            teamService.update(teamDTO);

            List<Team> teams = teamService.findAll(teamDTO.getChampId());
            currentChampionship = teams.get(0).getChampionship();

            model.addAttribute("currentChampionship", currentChampionship);
            model.addAttribute("teams", teams);

            return "teamList";
        }

        String message = "Team already exists";
        currentChampionship = champService.findOne(teamDTO.getChampId());

        model.addAttribute("message", message);
        model.addAttribute("currentChampionship", currentChampionship);

        return "teamError";
    }

    @RequestMapping(value = "play", method = RequestMethod.POST)
    public String play(@ModelAttribute("result") ResultDTO resultDTO, Model model) {
        Championship currentChampionship;

        if(validator.rivalsIsValid(resultDTO)) {
            statService.playGame(resultDTO);

            currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();
            List<Team> teams = currentChampionship.getParticipants();

            model.addAttribute("currentChampionship", currentChampionship);
            model.addAttribute("teams", teams);

            return "teamList";
        }

        String message = "You chose the same team";
        currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();

        model.addAttribute("message", message);
        model.addAttribute("currentChampionship", currentChampionship);

        return "teamError";
    }
}
