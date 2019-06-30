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

import java.util.List;

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

        if(teamService.hasTeam(teamDTO)) {
            String message = "Team already exists";
            currentChampionship = champService.findOne(teamDTO.getChampId());

            model.addAttribute("message", message);
            model.addAttribute("currentChampionship", currentChampionship);

            return "teamError";
        }

        teamService.save(teamDTO);

        List<Team> teams = teamService.findAll(teamDTO.getChampId());
        currentChampionship = teams.get(0).getChampionship();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
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

        if(teamService.hasTeam(teamDTO)) {
            String message = "Team already exists";
            currentChampionship = champService.findOne(teamDTO.getChampId());

            model.addAttribute("message", message);
            model.addAttribute("currentChampionship", currentChampionship);

            return "teamError";
        }

        teamService.update(teamDTO);

        List<Team> teams = teamService.findAll(teamDTO.getChampId());
        currentChampionship = teams.get(0).getChampionship();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }

    @RequestMapping(value = "play", method = RequestMethod.POST)
    public String play(@ModelAttribute("result") ResultDTO resultDTO, Model model) {
        Championship currentChampionship;

        if(resultDTO.getHomeTeamId().equals(resultDTO.getGuestTeamId())) {
            String message = "You chose the same team";
            currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();

            model.addAttribute("message", message);
            model.addAttribute("currentChampionship", currentChampionship);

            return "teamError";
        }

        statService.playGame(resultDTO);

        currentChampionship = teamService.findOne(resultDTO.getHomeTeamId()).getChampionship();
        List<Team> teams = currentChampionship.getParticipants();

        model.addAttribute("currentChampionship", currentChampionship);
        model.addAttribute("teams", teams);

        return "teamList";
    }
}
