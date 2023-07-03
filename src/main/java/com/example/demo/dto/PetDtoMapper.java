package com.example.demo.dto;

import com.example.demo.model.Pet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class PetDtoMapper implements Function<Pet,PetDto> {
    PersonDtoMapper personDtoMapper;
    @Override
    public PetDto apply(Pet pet) {
        return new PetDto(pet.getAge(), pet.getName(),pet.getPerson() );
    }
}
