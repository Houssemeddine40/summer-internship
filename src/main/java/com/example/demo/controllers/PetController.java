package com.example.demo.controllers;


import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@AllArgsConstructor
@RequestMapping("Pets")
public class PetController {

    private final PetService petService;
    private final PersonRepository personRepository;
    private final PetRepository petRepository;

    @PostMapping("/addPet")
    ResponseEntity<?> addPet(@RequestBody PetDto petDto){
        if (personRepository.existsById(petDto.person().getId())){
            petService.addPet(petDto);
            return ResponseEntity.ok().body("added successfuly");
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/getAll")
    ResponseEntity<?> getAll(){
        return ResponseEntity.ok(petService.getAllPets());
    }

    @DeleteMapping("/{idPet}")
    ResponseEntity<?> deletePet(@PathVariable("idPet") int id ){
        if (petRepository.existsById(id)){
            petService.delete(id);
            return ResponseEntity.ok().body("deleted successfuly");
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{idPet}")
    ResponseEntity<?> updatePet(@PathVariable("idPet") int id,@RequestBody Pet petRequest){
        if (petRepository.existsById(id)){
            petService.updatePet(id,petRequest);
            return ResponseEntity.ok().body("updated successfuly");
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }
}
