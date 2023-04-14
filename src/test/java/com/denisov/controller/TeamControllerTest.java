package com.denisov.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeamControllerTest {

    private static final String VALID_TEAM_NAME   = "New team";
    private static final String INVALID_TEAM_NAME = "Lokomotiv";

    private static final String DEFAULT_ENDPOINT = "/team";
    private static final String LIST_ENDPOINT    = DEFAULT_ENDPOINT + "/list/{champId}";
    private static final String CREATE_ENDPOINT  = DEFAULT_ENDPOINT + "/create";
    private static final String EDIT_ENDPOINT    = DEFAULT_ENDPOINT + "/edit/{teamId}";
    private static final String UPDATE_ENDPOINT  = DEFAULT_ENDPOINT + "/update";
    private static final String DELETE_ENDPOINT  = DEFAULT_ENDPOINT + "/delete/{champId}";
    private static final String PLAY_ENDPOINT    = DEFAULT_ENDPOINT + "/play";

    private static final String RUSSIA_ID          = "1";
    private static final String LOKOMOTIV_ID       = "1";
    private static final String SPARTAK_ID         = "2";
    private static final String KRASNODAR_ID       = "3";
    private static final String NEW_LOKOMOTIV_NAME = "Loko";
    private static final String SPARTAK_NAME       = "Spartak";

    private static final String PARAM_ID               = "id";
    private static final String PARAM_NAME             = "name";
    private static final String PARAM_CHAMP_ID         = "champId";
    private static final String PARAM_HOME_TEAM_ID     = "homeTeamId";
    private static final String PARAM_GUEST_TEAM_ID    = "guestTeamId";
    private static final String PARAM_HOME_TEAM_GOALS  = "homeGoals";
    private static final String PARAM_GUEST_TEAM_GOALS = "guestGoals";

    private static final String HOME_TEAM_GOALS_COUNT  = "0";
    private static final String GUEST_TEAM_GOALS_COUNT = "0";

    private static final String LIST_JSP  = "/WEB-INF/jsp/teamList.jsp";
    private static final String ERROR_JSP = "/WEB-INF/jsp/teamError.jsp";
    private static final String EDIT_JSP  = "/WEB-INF/jsp/editTeam.jsp";;


    @Autowired
    private MockMvc mockMvc;


    @Test
    @Order(1)
    void listTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(LIST_ENDPOINT, RUSSIA_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(2)
    void saveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(CREATE_ENDPOINT)
                .param(PARAM_NAME, VALID_TEAM_NAME)
                .param(PARAM_CHAMP_ID, RUSSIA_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(3)
    void saveErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(CREATE_ENDPOINT)
                .param(PARAM_NAME, INVALID_TEAM_NAME)
                .param(PARAM_CHAMP_ID, RUSSIA_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(ERROR_JSP));
    }

    @Test
    @Order(4)
    void editTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(EDIT_ENDPOINT, LOKOMOTIV_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(EDIT_JSP));
    }

    @Test
    @Order(5)
    void updateTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(UPDATE_ENDPOINT)
                .param(PARAM_ID, LOKOMOTIV_ID)
                .param(PARAM_NAME, NEW_LOKOMOTIV_NAME)
                .param(PARAM_CHAMP_ID, RUSSIA_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(6)
    void updateErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(UPDATE_ENDPOINT)
                .param(PARAM_ID, LOKOMOTIV_ID)
                .param(PARAM_NAME, SPARTAK_NAME)
                .param(PARAM_CHAMP_ID, RUSSIA_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(ERROR_JSP));
    }

    @Test
    @Order(7)
    void deleteTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(DELETE_ENDPOINT, LOKOMOTIV_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(8)
    void playTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(PLAY_ENDPOINT)
                .param(PARAM_HOME_TEAM_ID, SPARTAK_ID)
                .param(PARAM_GUEST_TEAM_ID, KRASNODAR_ID)
                .param(PARAM_HOME_TEAM_GOALS, HOME_TEAM_GOALS_COUNT)
                .param(PARAM_GUEST_TEAM_GOALS, GUEST_TEAM_GOALS_COUNT))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(8)
    void playErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(PLAY_ENDPOINT)
                .param(PARAM_HOME_TEAM_ID, SPARTAK_ID)
                .param(PARAM_GUEST_TEAM_ID, SPARTAK_ID)
                .param(PARAM_HOME_TEAM_GOALS, HOME_TEAM_GOALS_COUNT)
                .param(PARAM_GUEST_TEAM_GOALS, GUEST_TEAM_GOALS_COUNT))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(ERROR_JSP));
    }


}
