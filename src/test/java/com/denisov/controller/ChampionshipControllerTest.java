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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChampionshipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String VALID_CHAMP_NAME   = "New champ";
    private static final String INVALID_CHAMP_NAME = "Russia";
    private static final String NEW_SPAIN_NAME     = "new Spain";
    private static final String RUSSIA_NAME        = "Russia";

    private static final String RUSSIA_ID = "1";
    private static final String SPAIN_ID  = "3";


    private static final String LIST_JSP  = "/WEB-INF/jsp/championshipList.jsp";
    private static final String ERROR_JSP = "/WEB-INF/jsp/champError.jsp";
    private static final String EDIT_JSP  = "/WEB-INF/jsp/editChamp.jsp";

    private static final String PARAM_ID   = "id";
    private static final String PARAM_NAME = "name";

    private static final String DEFAULT_ENDPOINT = "/";
    private static final String LIST_ENDPOINT    = "/list";
    private static final String CREATE_ENDPOINT  = "/create";
    private static final String EDIT_ENDPOINT    = "/edit/{champId}";
    private static final String UPDATE_ENDPOINT  = "/update";
    private static final String DELETE_ENDPOINT  = "/delete/{champId}";


    @Test
    @Order(1)
    void defaultEndpointTest() throws Exception {
        mockMvc.perform(get(DEFAULT_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(2)
    void listTest() throws Exception {
        mockMvc.perform(get(LIST_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(3)
    void saveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(CREATE_ENDPOINT)
                .param(PARAM_NAME, VALID_CHAMP_NAME))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(4)
    void saveErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(CREATE_ENDPOINT)
                .param(PARAM_NAME, INVALID_CHAMP_NAME))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(ERROR_JSP));
    }
    
    @Test
    @Order(5)
    void editTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(EDIT_ENDPOINT, RUSSIA_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(EDIT_JSP));
    }

    @Test
    @Order(6)
    void updateTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(UPDATE_ENDPOINT)
                .param(PARAM_ID, SPAIN_ID)
                .param(PARAM_NAME, NEW_SPAIN_NAME))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }

    @Test
    @Order(7)
    void updateErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post(UPDATE_ENDPOINT)
                .param(PARAM_ID, SPAIN_ID)
                .param(PARAM_NAME, RUSSIA_NAME))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(ERROR_JSP));
    }

    @Test
    @Order(8)
    void deleteTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get(DELETE_ENDPOINT, SPAIN_ID))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl(LIST_JSP));
    }
}