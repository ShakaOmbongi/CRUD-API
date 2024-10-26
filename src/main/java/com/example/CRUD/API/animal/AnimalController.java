package com.example.CRUD.API.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    /**
     * Display all animals.
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", animalService.findAll());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Display details of a specific animal by ID.
     */
    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid animal Id: " + id)));
        model.addAttribute("title", "Animal Details");
        return "animal-details";
    }

    /**
     * Show form to create a new animal.
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    /**
     * Process form submission to create a new animal.
     */
    @PostMapping("/new")
    public String createAnimal(Animal animal) {
        animalService.save(animal);
        return "redirect:/animals/all";
    }

    /**
     * Show form to update an existing animal.
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid animal Id: " + id));
        model.addAttribute("animal", animal);
        return "animal-update";
    }

    /**
     * Process form submission to update an existing animal.
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        animalService.save(animal);
        return "redirect:/animals/" + animal.getId();
    }

    /**
     * Delete an animal by its ID.
     */
    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable Long id) {
        animalService.deleteById(id);
        return "redirect:/animals/all";
    }
}
