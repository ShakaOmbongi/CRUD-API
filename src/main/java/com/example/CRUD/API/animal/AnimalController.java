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

    @GetMapping("/all")
    public String listAnimals(Model model) {
        model.addAttribute("animals", animalService.findAll());
        return "animal-list";
    }

    @GetMapping("/{id}")
    public String showAnimalDetails(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid animal Id:" + id));
        model.addAttribute("animal", animal);
        return "animal-details";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    @PostMapping("/new")
    public String createAnimal(@ModelAttribute Animal animal) {
        animalService.save(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid animal Id:" + id));
        model.addAttribute("animal", animal);
        return "animal-update";
    }

    @PostMapping("/update")
    public String updateAnimal(@ModelAttribute Animal animal) {
        animalService.save(animal);
        return "redirect:/animals/" + animal.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteById(id);
        return "redirect:/animals/all";
    }
}
