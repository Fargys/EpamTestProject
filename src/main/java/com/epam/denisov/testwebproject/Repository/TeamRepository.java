package com.epam.denisov.testwebproject.Repository;

import com.epam.denisov.testwebproject.model.Championship;
import com.epam.denisov.testwebproject.model.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByName(String name);
    List<Team> findAllByChampionship(Championship championship);
}
