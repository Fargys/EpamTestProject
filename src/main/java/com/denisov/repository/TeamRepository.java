package com.denisov.repository;

import com.denisov.entity.Championship;
import com.denisov.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByName(String name);
    List<Team> findAllByChampionship(Championship championship);
}
