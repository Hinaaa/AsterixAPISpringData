package com.example.asterixapispringdata.Service;

import com.example.asterixapispringdata.Model.Character;
import com.example.asterixapispringdata.Repository.CharacterRepository;
import lombok.With;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    //get all
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    //post
    public Character addCharacter(@RequestBody Character newCharacter) {
        return characterRepository.save(newCharacter);
    }

    //update - put
    public Character updateCharacter(@PathVariable String id, @RequestBody Character updatedCharacter) {
        Character oldCharacter = characterRepository.findById(id).orElse(null);
        if (oldCharacter != null) {
            characterRepository.save(oldCharacter
                    .withName(updatedCharacter.name())
                    .withAge(updatedCharacter.age())
                    .withProfession(updatedCharacter.profession()));
        }
        return updatedCharacter;
    }
    //Delete
    public void deleteCharacter(@PathVariable String id) {
        characterRepository.deleteById(id);
    }
}
