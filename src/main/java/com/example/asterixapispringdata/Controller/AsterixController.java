package com.example.asterixapispringdata.Controller;

import com.example.asterixapispringdata.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.asterixapispringdata.Model.Character;

@RestController
public class AsterixController {
    // Declare the repository at the class level
    private final CharacterRepository characterRepository;

    public AsterixController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    //Get
    @GetMapping("/asterix/characters")
    public List<Character> asterixCharacters() {
        // Declare the repository as an instance variable
        return characterRepository.findAll();
    }
    //Create, Post
    @PostMapping("/asterix/characters")
    public Character addCharcter(@RequestBody Character newCharacter) {
        return characterRepository.save(newCharacter);
    }
    //Update - Put
    @PutMapping("asterix/characters/{id}")
    public Character updatedChacrter(@PathVariable String id, @RequestBody Character updateCharacter) {
        Character oldCharacter = characterRepository.findById(id).orElse(null);
        if (oldCharacter != null) {
            characterRepository.save(oldCharacter
                    .withName(updateCharacter.name()) //// Update the character using "with" methods
                    .withAge(updateCharacter.age())
                    .withProfession(updateCharacter.profession()));
        }
        return updateCharacter;
    }   //Delete
    @DeleteMapping("asterix/characters/{id}")
    public void deleteCharcter(@PathVariable String id) {
        characterRepository.deleteById(id);
    }
}