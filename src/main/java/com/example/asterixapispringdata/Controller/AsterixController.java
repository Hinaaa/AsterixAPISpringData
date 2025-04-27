package com.example.asterixapispringdata.Controller;

import com.example.asterixapispringdata.Model.CharacterDto;
import com.example.asterixapispringdata.Repository.CharacterRepository;
import com.example.asterixapispringdata.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.asterixapispringdata.Model.Character;

@RestController
public class AsterixController {
    // Declare the repository at the class level
   private final CharacterService characterService;
    private final CharacterRepository characterRepository;

    @Autowired
    public AsterixController(CharacterService characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
        this.characterRepository = characterRepository;
    }

    //Get
    @GetMapping("/asterix/characters")
    public List<Character> asterixCharacters() {
        // Declare the repository as an instance variable
        return characterService.getAllCharacters();
    }
    //Create, Post //Take random generated Id. //from: @RequestBody Character newCharacter
    @PostMapping("/asterix/characters")
    public Character addCharcter(@RequestBody CharacterDto newCharacterDtp) {
        return characterService.addCharacter(newCharacterDtp);
    }
    //Update - Put
    @PutMapping("asterix/characters/{id}")
    public Character updatedChacrter(@PathVariable String id, @RequestBody CharacterDto updateCharacter) {
        return characterService.updateCharacter(id, updateCharacter);
    }
    //Delete
    @DeleteMapping("asterix/characters/{id}")
    public void deleteCharcter(@PathVariable String id) {
        characterService.deleteCharacter(id);
    }
}