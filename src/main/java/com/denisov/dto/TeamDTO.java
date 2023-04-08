package com.denisov.dto;

import lombok.Data;

@Data
public class TeamDTO {
    private String id;
    private String name;
    private String games;
    private String wins;
    private String draws;
    private String losses;
    private String scored;
    private String missed;
    private String points;
    private String champId;
}
