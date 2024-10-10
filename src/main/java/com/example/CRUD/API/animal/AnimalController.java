package com.example.CRUD.API.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

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

    @GetMapping("/class/{animalClass}")
    public List<Animal> getByClass(@PathVariable String animalClass) {
        return service.findByAnimalClass(animalClass);
    }

    @GetMapping("/search")
    public List<Animal> searchByName(@RequestParam String name) {
        return service.findByNameContaining(name);
    }
}
