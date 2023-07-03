package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.PetDto;
import com.example.demo.model.Person;
import com.example.demo.model.Pet;

import java.util.List;

public interface PersonService {
    PersonDto addPerson(PersonDto personDto);
    List<PersonDto> getAllPersons();
    void delete(int id);
    void updatePerson(int id, Person personRequest);


}
