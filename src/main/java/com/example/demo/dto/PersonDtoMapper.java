package com.example.demo.dto;

import com.example.demo.model.Person;
import com.example.demo.model.Pet;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PersonDtoMapper implements Function<Person,PersonDto> {
    @Override
    public PersonDto apply(Person person) {
        return new PersonDto(person.getAge(),person.getName());
    }
}
