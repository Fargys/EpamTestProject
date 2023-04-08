package com.denisov.repository;

import com.denisov.entity.Championship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends CrudRepository<Championship, Long> {
    Championship findByName(String name);
}
