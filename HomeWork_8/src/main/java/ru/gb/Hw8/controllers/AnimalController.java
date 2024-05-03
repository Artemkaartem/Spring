package ru.gb.Hw8.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.Hw8.models.Animal;
import ru.gb.Hw8.services.AnimalService;

@Controller
@AllArgsConstructor
public class AnimalController {

    private AnimalService animalService;

    /**
     * Получить всех животных
     * @param model
     * @return
     */
    @GetMapping("/animals")
    public String getAnimal(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animals";
    }

    /**
     * Добавить животное
     * @param animal
     * @param model
     * @return
     */
    @PostMapping("/animals")
    public String addAnimal(Animal animal, Model model) {
        animalService.addAnimal(animal);
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animals";
    }
}