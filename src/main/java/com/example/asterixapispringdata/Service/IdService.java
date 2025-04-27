package com.example.asterixapispringdata.Service;

import com.example.asterixapispringdata.Repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    private final CharacterRepository characterRepository;

    public IdService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    public String generateRandomId() {
        return UUID.randomUUID().toString();
    }
}
