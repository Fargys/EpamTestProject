package com.denisov.repository;

import com.denisov.entity.Championship;
import com.denisov.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByName(String name);
    List<Team> findAllByChampionship(Championship championship);
}
