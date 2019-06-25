package com.epam.denisov.testwebproject.Repository;

import com.epam.denisov.testwebproject.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
