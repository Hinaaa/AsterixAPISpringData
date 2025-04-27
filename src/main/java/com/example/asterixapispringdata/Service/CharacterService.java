package com.example.asterixapispringdata.Service;

import com.example.asterixapispringdata.Model.Character;
import com.example.asterixapispringdata.Model.CharacterDto;
import com.example.asterixapispringdata.Repository.CharacterRepository;
import lombok.With;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final IdService idService;

    public CharacterService(CharacterRepository characterRepository, IdService idService) {
        this.characterRepository = characterRepository;
        this.idService = idService;
    }

    //get all
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    //post - With Random ID
    //from: @RequestBody Character newCharacter
    public Character addCharacter(@RequestBody CharacterDto newCharacterDto) {
        //adding step for using random generated id
       String generatedId = idService.generateRandomId();
        // Create the new character with the generated ID
        Character newCharacter = new Character(generatedId, newCharacterDto.name(), newCharacterDto.age(), newCharacterDto.profession());
        return characterRepository.save(newCharacter);
    }

    //update - put - use generated id, so user cant chnage it
    //from:     public Character updateCharacter(@PathVariable String id, @RequestBody Character updatedCharacter) {
    public Character updateCharacter(@PathVariable String id, @RequestBody CharacterDto updatedCharacter) {
        Character oldCharacter = characterRepository.findById(id).orElse(null);
        if (oldCharacter != null) {
            oldCharacter = characterRepository.save(oldCharacter //saved here in oldCharacter
                    .withName(updatedCharacter.name())
                    .withAge(updatedCharacter.age())
                    .withProfession(updatedCharacter.profession()));
        }
        return oldCharacter; //Returns the updated character
    }
    //Delete
    public void deleteCharacter(@PathVariable String id) {
        characterRepository.deleteById(id);
    }
}
