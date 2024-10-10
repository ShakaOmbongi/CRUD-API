package com.example.CRUD.API.animal;

import jakarta.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    private String scientificName;

    @Column(nullable = false)
    private String animalClass;

    @Column(nullable = false)
    private String habitat;

    private String description;

    // Constructors, Getters and Setters
    public Animal() {}

    public Animal(String name, String scientificName, String animalClass, String habitat, String description) {
        this.name = name;
        this.scientificName = scientificName;
        this.animalClass = animalClass;
        this.habitat = habitat;
        this.description = description;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public void setAnimalClass(String animalClass) {
        this.animalClass = animalClass;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
