package com.example.CRUD.API.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByAnimalClass(String animalClass);
    List<Animal> findByNameContaining(String name);
}
