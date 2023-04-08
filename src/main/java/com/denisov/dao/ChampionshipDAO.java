package com.denisov.dao;

import com.denisov.model.Championship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipDAO extends CrudRepository<Championship, Long> {
    Championship findByName(String name);
}
