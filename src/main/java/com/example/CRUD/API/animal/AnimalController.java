package com.example.CRUD.API.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @Autowired
    private AnimalApiService animalApiService;

    // Local database operations
    @GetMapping
    public List<Animal> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return service.save(animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal) {
        animal.setAnimalId(id);
        return service.save(animal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/species/{species}")
    public List<Animal> getBySpecies(@PathVariable String species) {
        return service.findBySpecies(species);
    }

    @GetMapping("/search")
    public List<Animal> searchByName(@RequestParam String name) {
        return service.findByNameContaining(name);
    }

    // External API operations
    @GetMapping("/external/all")
    public String getAllAnimalsExternal() {
        return animalApiService.getAllAnimals();
    }

    @GetMapping("/external/name/{name}")
    public String getAnimalByNameExternal(@PathVariable String name) {
        return animalApiService.getAnimalByName(name);
    }

    @GetMapping("/external/id/{id}")
    public String getAnimalByIdExternal(@PathVariable String id) {
        return animalApiService.getAnimalById(id);
    }
}
