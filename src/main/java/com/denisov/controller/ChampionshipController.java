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

    private static final String CHAMP_LIST_JSP  = "championshipList";
    private static final String CHAMP_ERROR_JSP = "champError";
    private static final String EDIT_CHAMP_JSP  = "editChamp";

    private static final String ATTR_CHAMPIONSHIPS        = "championships";
    private static final String ATTR_CURRENT_CHAMPIONSHIP = "currentChampionship";
    private static final String ATTR_MESSAGE              = "message";

    private static final String ERROR_MESSAGE = "Championship already exists";


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

        model.addAttribute(ATTR_CHAMPIONSHIPS, championships);

        return CHAMP_LIST_JSP;
    }

    @PostMapping(value = "/create")
     public String save(@ModelAttribute ChampionshipDTO champDTO, Model model) {
        if(validator.champIsValid(champDTO)) {
            champService.save(champDTO);

            List<Championship> championships = champService.findAll();

            model.addAttribute(ATTR_CHAMPIONSHIPS, championships);

            return CHAMP_LIST_JSP;
        }

        model.addAttribute(ATTR_MESSAGE, ERROR_MESSAGE);

        return CHAMP_ERROR_JSP;
    }

    @GetMapping(value = "/edit/{champId}")
    public String edit(@PathVariable("champId") String champId, Model model) {
        Championship currentChampionship = champService.findOne(champId);

        model.addAttribute(ATTR_CURRENT_CHAMPIONSHIP, currentChampionship);

        return EDIT_CHAMP_JSP;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute ChampionshipDTO champDTO, Model model) {
        if(validator.updateChampIsValid(champDTO)) {
            champService.update(champDTO);

            List<Championship> championships = champService.findAll();

            model.addAttribute(ATTR_CHAMPIONSHIPS, championships);

            return CHAMP_LIST_JSP;
        }

        model.addAttribute(ATTR_MESSAGE, ERROR_MESSAGE);

        return CHAMP_ERROR_JSP;
    }

    @GetMapping(value = "/delete/{champId}")
    public String delete(@PathVariable("champId") String champId, Model model) {
        champService.delete(champId);
        List<Championship> championships = champService.findAll();

        model.addAttribute(ATTR_CHAMPIONSHIPS, championships);

        return CHAMP_LIST_JSP;
    }
}
