package com.example.demo.controllers;


import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("Pets")
public class PetController {

    PetService petService;
 // @PathVariable
    @PostMapping("/addPet")
    Pet addPet(@RequestBody Pet pet){
        System.out.println(pet.toString());
        return petService.addPet(pet);
    }

    @GetMapping("/getAll")
    List<Pet> getAll(){
        return petService.getAllPets();
    }

    @DeleteMapping("/{idPet}")
    void deletePet(@PathVariable("idPet") int id ){
        petService.delete(id);
    }

    @PutMapping("/{idPet}")
    void updatePet(@PathVariable("idPet") int id,@RequestBody Pet petRequest){
    petService.updatePet(id,petRequest);

    }




}
