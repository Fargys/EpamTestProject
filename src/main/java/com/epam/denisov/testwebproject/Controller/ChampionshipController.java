package com.epam.denisov.testwebproject.Controller;

import com.epam.denisov.testwebproject.Service.ChampionshipService;
import com.epam.denisov.testwebproject.dto.ChampionshipDTO;
import com.epam.denisov.testwebproject.model.Championship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/championship"})
public class ChampionshipController {

    private final ChampionshipService champService;

    @Autowired
    public ChampionshipController(ChampionshipService champService) {
        this.champService = champService;
    }


    @RequestMapping(value = {"/", "/list"} , method = RequestMethod.GET)
    public String list(Model model) {
        List<Championship> championships = champService.findAll();

        model.addAttribute("championships", championships);

        return "championshipList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
     public String save(@ModelAttribute ChampionshipDTO champDTO, Model model) {
        if(champService.hasChampionship(champDTO)) {
            String message = "Championship already exists";
            model.addAttribute("message", message);
            return "champError";
        }

        champService.save(champDTO);

        List<Championship> championships = champService.findAll();

        model.addAttribute("championships", championships);

        return "championshipList";
    }

    @RequestMapping(value = "/delete/{champId}", method = RequestMethod.GET)
    public String delete(@PathVariable("champId") String champId, Model model) {
        champService.delete(champId);
        List<Championship> championships = champService.findAll();

        model.addAttribute("championships", championships);

        return "championshipList";
    }

    @RequestMapping(value = "/edit/{champId}", method = RequestMethod.GET)
    public String edit(@PathVariable("champId") String champId, Model model) {
        Championship currentChampionship = champService.findOne(champId);

        model.addAttribute("currentChampionship", currentChampionship);

        return "editChamp";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute ChampionshipDTO champDTO, Model model) {
        if(champService.hasChampionship(champDTO)) {
            String message = "Championship already exists";
            model.addAttribute("message", message);
            return "champError";
        }
        champService.update(champDTO);

        List<Championship> championships = champService.findAll();

        model.addAttribute("championships", championships);

        return "championshipList";
    }
}
