package com.example.demo.controllers;


import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@AllArgsConstructor
@RequestMapping("Pets")
public class PetController {

    PetService petService;
 // @PathVariable
    @PostMapping("/addPet")
    ResponseEntity<?> addPet(@RequestBody PetDto petDto){
      //  System.out.println(pet.toString());
        petService.addPet(petDto);
        return ResponseEntity.ok().body("added successfuly");
    }


    @GetMapping("/getAll")
    ResponseEntity<?> getAll(){

        return ResponseEntity.ok(petService.getAllPets());
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
