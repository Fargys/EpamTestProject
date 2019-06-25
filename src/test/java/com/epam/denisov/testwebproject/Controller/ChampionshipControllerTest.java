package com.epam.denisov.testwebproject.Controller;

import com.epam.denisov.testwebproject.TestWebProjectApplication;
import com.epam.denisov.testwebproject.model.Championship;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestWebProjectApplication.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class ChampionshipControllerTest {

    @Autowired
    ChampionshipController chController;


//    @Test
//    public void find() {
//        Championship actualResult = chController.findOne(1L);
//        String expectedResult = "Russia";
//        Assert.assertEquals(expectedResult, actualResult.getName());
//    }

//    @Test
//    public void create() {
//        int expectedResult = 4;
//        chController.create(4L, "Spain");
//        int actualResult = chController.getChampionships().size();
//        Assert.assertEquals(expectedResult, actualResult);
//    }

//    @Test
//    public void update() {
//        String expectedResult = "newRussia";
//        chController.update(1L, "newRussia");
//        Championship actualResult = chController.findOne(1L);
//        Assert.assertEquals(expectedResult, actualResult.getName());
//    }

//    @Test
//    public void delete() {
//        int expectedResult = 2;
//        chController.delete(1L);
//        int actualResult = chController.getChampionships().size();
//        Assert.assertEquals(expectedResult, actualResult);
//    }
}