package com.epam.denisov.testwebproject.Repository;

import com.epam.denisov.testwebproject.model.Championship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends CrudRepository<Championship, Long> {
    Championship findByName(String name);
}
