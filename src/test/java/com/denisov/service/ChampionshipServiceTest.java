package com.denisov.service;

import com.denisov.dto.ChampionshipDTO;
import com.denisov.entity.Championship;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChampionshipServiceTest {

    @Autowired
    private ChampionshipService champService;

    private static final Integer CHAMPIONSHIPS_COUNT = 3;
    private static final String RUSSIA_CHAMP_ID = "1";
    private static final String RUSSIA_CHAMP_NAME = "Russia";
    private static final String NEW_CHAMP_NAME = "New champ";
    private static final String UPDATE_NEW_CHAMP_NAME = "update champ";


    @Test
    @Order(1)
    void findOneLongTest() {
        Championship champ  = champService.findOne(Long.parseLong(RUSSIA_CHAMP_ID));

        assertNotNull(champ);
        assertEquals(RUSSIA_CHAMP_NAME, champ.getName());
    }

    @Test
    @Order(2)
    void findOneStringTest() {
        Championship champ  = champService.findOne(RUSSIA_CHAMP_ID);

        assertNotNull(champ);
        assertEquals(RUSSIA_CHAMP_NAME, champ.getName());
    }

    @Test
    @Order(3)
    void findByNameTest() {
        Championship champ  = champService.findByName(RUSSIA_CHAMP_NAME);

        assertNotNull(champ);
        assertEquals(RUSSIA_CHAMP_NAME, champ.getName());
    }

    @Test
    @Order(4)
    void findAllTest() {
        List<Championship> champs = champService.findAll();
        int actualCount = champs.size();

        assertNotNull(champs);
        assertEquals(CHAMPIONSHIPS_COUNT, actualCount);
    }

    @Test
    @Order(5)
    void saveTest() {
        ChampionshipDTO newChampDTO = new ChampionshipDTO();
        newChampDTO.setName(NEW_CHAMP_NAME);

        champService.save(newChampDTO);

        Championship champ  = champService.findByName(NEW_CHAMP_NAME);
        assertNotNull(champ);
        assertNotNull(champ.getId());
    }


    @Test
    @Order(6)
    void updateTest() {
        ChampionshipDTO champDTO = new ChampionshipDTO();
        champDTO.setId(champService.findByName(NEW_CHAMP_NAME).getId().toString());
        champDTO.setName(UPDATE_NEW_CHAMP_NAME);

        Championship italy = champService.update(champDTO);
        assertNotNull(italy.getId().toString());
        assertEquals(UPDATE_NEW_CHAMP_NAME, italy.getName());
    }

    @Test
    @Order(7)
    void deleteTest() {
        String italyId = champService.findByName(UPDATE_NEW_CHAMP_NAME).getId().toString();
        Championship champ  = champService.findOne(italyId);
        assertNotNull(champ);

        champService.delete(italyId);

        champ = champService.findOne(italyId);
        assertNull(champ);
    }
}