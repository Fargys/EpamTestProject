package com.denisov.dao;

import com.denisov.model.Championship;
import com.denisov.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamDAO extends CrudRepository<Team, Long> {
    Team findByName(String name);
    List<Team> findAllByChampionship(Championship championship);
}
