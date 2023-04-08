package com.denisov.service;

import com.denisov.service.ChampionshipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChampionshipServiceTest {

    @Autowired
    public ChampionshipService champService;

    @Test
    public void findOne() {
//        String russiaId = "1";
//        Championship result = champService.findOne(russiaId);
//        Assert.assertNotNull(result);
//
//        Set<Team> teams = result.getParticipants();
//        Assert.assertNotNull(teams);
//        Assert.assertFalse(teams.isEmpty());
    }

    @Test
    public void findAll() {
//        List<Championship> result = champService.findAll();
//        Assert.assertNotNull(result);
//
//        int expectedSize = 3;
//        int resultSize = result.size();
//        Assert.assertEquals(expectedSize, resultSize);
    }

//    @Test
//    public void save() {
//        String newChampName = "newChamp";
//        champService.save(newChampName);
//        Championship newChamp = champService.findByName(newChampName);
//        Assert.assertNotNull(newChamp);
//        Assert.assertEquals(newChampName, newChamp.getName());
//    }

    @Test
    public void delete() {
//        Championship newChamp = new Championship("newChamp");
//        champService.save(newChamp);
//
//        Championship beforeDeleted = champService.findByName("newChamp");
//        Assert.assertNotNull(beforeDeleted);
//
//        champService.delete(beforeDeleted.getId());
//        Championship afterDeleted = champService.findByName("newChamp");
//        Assert.assertNull(afterDeleted);
    }
}