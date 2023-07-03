package com.example.demo.controllers;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping("/add")
    ResponseEntity<?> addPerson(@RequestBody PersonDto personDto){
        personService.addPerson(personDto);
        return ResponseEntity.ok("added successfuly");
    }
    @GetMapping("/getAll")
    ResponseEntity<?> getAllPerson(){
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PutMapping("/{idPerson}")
    ResponseEntity<?> update(@PathVariable int idPerson,@RequestBody Person person){
        if (personRepository.existsById(idPerson)){
            personService.updatePerson(idPerson,person);
            return ResponseEntity.ok().body("updated successfuly");
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{idPerson}")
    ResponseEntity<?> delete(@PathVariable int idPerson){
        if (personRepository.existsById(idPerson))
        {
            personService.delete(idPerson);
            return ResponseEntity.ok().body("deleted successfuly");
        }else
        {
            return ResponseEntity.notFound().build();
        }


    }
}
