package com.example.CRUD.API.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public Animal findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Animal save(Animal animal) {
        return repository.save(animal);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Animal> findByAnimalClass(String animalClass) {
        return repository.findByAnimalClass(animalClass);
    }

    public List<Animal> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }
}
