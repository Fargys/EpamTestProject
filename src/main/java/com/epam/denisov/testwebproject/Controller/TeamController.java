package com.epam.denisov.testwebproject.Controller;

import com.epam.denisov.testwebproject.Service.ChampionshipService;
import com.epam.denisov.testwebproject.Service.TeamService;
import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

    private final TeamService teamService;
    private final ChampionshipService champService;

    @Autowired
    public TeamController(ChampionshipService champService, TeamService teamService) {
        this.teamService = teamService;
        this.champService = champService;
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
    public String save(@RequestParam String teamName, @RequestParam String champId, Model model) {
        teamService.save(teamName, champId);

        Championship currentChampionship = champService.findOne(champId);
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

    @RequestMapping(value = "/update/{teamId}", method = RequestMethod.POST)
    public String update(@PathVariable("teamId") String teamId, @RequestParam String newName, Model model) {
        teamService.update(teamId, newName);

        Championship currentChampionship = teamService.findOne(teamId).getChampionship();
        Set<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }
}
