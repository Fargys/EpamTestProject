package com.epam.denisov.testwebproject.Controller;

import com.epam.denisov.testwebproject.Service.ChampionshipService;
import com.epam.denisov.testwebproject.Service.StatisticsService;
import com.epam.denisov.testwebproject.Service.TeamService;
import com.epam.denisov.testwebproject.dto.ResultDTO;
import com.epam.denisov.testwebproject.dto.TeamDTO;
import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

    private final TeamService teamService;
    private final ChampionshipService champService;
    private final StatisticsService statService;

    @Autowired
    public TeamController(ChampionshipService champService, TeamService teamService, StatisticsService statService) {
        this.teamService = teamService;
        this.champService = champService;
        this.statService = statService;
    }

    @RequestMapping(value = { "/list/{champId}" }, method = RequestMethod.GET)
    public String list(Model model, @PathVariable("champId") String champId) {

        Championship currentChampionship = champService.findOne(champId);
        Set<Team> teams = currentChampionship.getParticipants();

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
        Set<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@ModelAttribute TeamDTO teamDTO, Model model) {
        teamService.save(teamDTO);

        Championship currentChampionship = champService.findOne(teamDTO.getChampId());
        Set<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }

    @RequestMapping(value = "/edit/{teamId}", method = RequestMethod.GET)
    public String edit(@PathVariable("teamId") String teamId, Model model) {
        Team currentTeam = teamService.findOne(teamId);

        model.addAttribute("currentTeam", currentTeam);

        return "editTeam";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute TeamDTO teamDTO, Model model) {
        teamService.update(teamDTO);

        Championship currentChampionship = teamService.findOne(teamDTO.getId()).getChampionship();
        Set<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }

    @RequestMapping(value = "play", method = RequestMethod.POST)
    public String play(@ModelAttribute("result") ResultDTO resultDTO, Model model) {
        statService.playGame(resultDTO);

        Championship currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();
        Set<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }
}
