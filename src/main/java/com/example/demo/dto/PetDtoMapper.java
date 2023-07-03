package com.example.demo.dto;

import com.example.demo.model.Pet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PetDtoMapper implements Function<Pet,PetDto> {
    @Override
    public PetDto apply(Pet pet) {
        return new PetDto(pet.getAge(), pet.getName());
    }
}
