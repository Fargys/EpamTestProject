package com.denisov.controller;

import com.denisov.controller.ChampionshipController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ChampionshipControllerTest {

    @Autowired
    ChampionshipController chController;


    @Test
    public void find() {
//        Championship actualResult = chController.findOne(1L);
//        String expectedResult = "Russia";
//        Assert.assertEquals(expectedResult, actualResult.getName());
    }

    @Test
    public void create() {
//        int expectedResult = 4;
//        chController.create(4L, "Spain");
//        int actualResult = chController.getChampionships().size();
//        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void update() {
//        String expectedResult = "newRussia";
//        chController.update(1L, "newRussia");
//        Championship actualResult = chController.findOne(1L);
//        Assert.assertEquals(expectedResult, actualResult.getName());
    }

    @Test
    public void delete() {
//        int expectedResult = 2;
//        chController.delete(1L);
//        int actualResult = chController.getChampionships().size();
//        Assert.assertEquals(expectedResult, actualResult);
    }
}