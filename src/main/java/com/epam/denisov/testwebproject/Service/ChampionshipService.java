package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.Repository.ChampionshipRepository;
import com.epam.denisov.testwebproject.dto.ChampionshipDTO;
import com.epam.denisov.testwebproject.model.Championship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampionshipService {

    private final ChampionshipRepository champRepository;

    @Autowired
    public ChampionshipService(ChampionshipRepository champRepository) {
        this.champRepository = champRepository;
    }


    public Championship findOne(String champId) {
        Long currentId = Long.parseLong(champId, 10);

        return this.findOne(currentId);
    }

    public Championship findOne(Long champId) {
        return champRepository.findById(champId).orElse(null);
    }

    public Championship findByName(String name) {
        return champRepository.findByName(name);
    }

    public List<Championship> findAll() {
        Iterable<Championship> iterable = champRepository.findAll();
        List<Championship> result = new ArrayList<>();
        iterable.forEach(result::add);

        return result;
    }

    public void save(ChampionshipDTO champDTO) {
        Championship champ = new Championship(champDTO.getName());
        champRepository.save(champ);
    }

    public void delete(String champId) {
        Long id = Long.parseLong(champId, 10);
        champRepository.deleteById(id);
    }

    public void update(ChampionshipDTO champDTO) {
        Championship ch = this.findOne(champDTO.getId());
        ch.setName(champDTO.getName());

        champRepository.save(ch);
    }
}
