package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.TestWebProjectApplication;
import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestWebProjectApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
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