package com.example.asterixapispringdata.Repository;

import com.example.asterixapispringdata.Model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepository extends MongoRepository<Character, String> {
    List<Character> findByAgeLessThanEqual(Integer age); // Direct database query
}