    package com.example.asterixapispringdata.Model;

    import lombok.With;
    import org.springframework.data.mongodb.core.mapping.Document;
    @With
    @Document(collection = "character")//Linked to MongoDB collection named "character"
    public record Character(String id, String name, int age, String profession) {
    }