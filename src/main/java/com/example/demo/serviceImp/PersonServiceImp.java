package com.example.demo.serviceImp;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.PersonDtoMapper;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImp implements PersonService {
    PersonRepository personRepository;
    PersonDtoMapper personDtoMapper;
    @Override
    public PersonDto addPerson(PersonDto personDto) {
        Person person = new Person();
        person.setAge(personDto.age());
        person.setName(personDto.name());
        personRepository.save(person);
        return personDto;
    }

    @Override
    public List<PersonDto> getAllPersons() {

        return personRepository.findAll()
                .stream()
                .map(personDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        if (personRepository.existsById(id)){
            personRepository.deleteById(id);
        }

    }

    @Override
    public void updatePerson(int id, Person personRequest) {
        if (personRepository.existsById(id)){
           Person person =personRepository.findById(id).get();
           person.setName(personRequest.getName());
           person.setAge(personRequest.getAge());
        }

    }
}
