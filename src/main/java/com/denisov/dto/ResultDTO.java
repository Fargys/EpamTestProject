package com.denisov.dto;

import lombok.Data;

@Data
public class ResultDTO {
    String homeTeamId;
    String guestTeamId;
    int homeGoals;
    int guestGoals;
}
