package com.denisov.controller;

import com.denisov.entity.Championship;
import com.denisov.service.ChampionshipService;
import com.denisov.service.Validator;
import com.denisov.dto.ChampionshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/championship"})
public class ChampionshipController {

    private final ChampionshipService champService;
    private final Validator validator;

    @Autowired
    public ChampionshipController(ChampionshipService champService, Validator validator) {
        this.champService = champService;
        this.validator = validator;
    }


    @GetMapping(value = {"/", "/list"})
    public String list(Model model) {
        List<Championship> championships = champService.findAll();

        model.addAttribute("championships", championships);

        return "championshipList";
    }

    @PostMapping(value = "/create")
     public String save(@ModelAttribute ChampionshipDTO champDTO, Model model) {
        if(validator.champIsValid(champDTO)) {
            champService.save(champDTO);

            List<Championship> championships = champService.findAll();

            model.addAttribute("championships", championships);

            return "championshipList";
        }

        String message = "Championship already exists";
        model.addAttribute("message", message);

        return "champError";
    }

    @GetMapping(value = "/edit/{champId}")
    public String edit(@PathVariable("champId") String champId, Model model) {
        Championship currentChampionship = champService.findOne(champId);

        model.addAttribute("currentChampionship", currentChampionship);

        return "editChamp";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute ChampionshipDTO champDTO, Model model) {
        if(validator.updateChampIsValid(champDTO)) {
            champService.update(champDTO);

            List<Championship> championships = champService.findAll();

            model.addAttribute("championships", championships);

            return "championshipList";
        }

        String message = "Championship already exists";
        model.addAttribute("message", message);

        return "champError";
    }

    @GetMapping(value = "/delete/{champId}")
    public String delete(@PathVariable("champId") String champId, Model model) {
        champService.delete(champId);
        List<Championship> championships = champService.findAll();

        model.addAttribute("championships", championships);

        return "championshipList";
    }
}
