package com.example.CRUD.API.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // JpaRepository provides findById, save, deleteById, etc.
}
