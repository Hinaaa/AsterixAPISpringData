package com.example.asterixapispringdata.Repository;

import com.example.asterixapispringdata.Model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
}