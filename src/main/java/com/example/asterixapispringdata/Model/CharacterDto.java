package com.example.asterixapispringdata.Model;

public record CharacterDto(String name, int age, String profession) {
    // No id field here, so the client cannot specify an id
}
