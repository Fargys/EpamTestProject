package com.epam.denisov.testwebproject.Service;

import com.epam.denisov.testwebproject.Repository.ChampionshipRepository;
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

    //find
    public Championship findOne(String champId) {
        Long currentId = Long.parseLong(champId, 10);

        return champRepository.findOne(currentId);
    }

    public Championship findOne(Long champId) {
        return champRepository.findOne(champId);
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

    //save
    public void save(Championship newChamp) {
        champRepository.save(newChamp);
    }

    public void save(String champName) {
        Championship champ = new Championship(champName);
        champRepository.save(champ);
    }

    //delete
    public void delete(String champId) {
        Long id = Long.parseLong(champId, 10);
        champRepository.delete(id);
    }

    public void delete(Long champId) {
        champRepository.delete(champId);
    }

    //update
    public void update(String champId, String newName) {
        Championship champ = this.findOne(champId);
        champ.setName(newName);

        this.save(champ);
    }
}
