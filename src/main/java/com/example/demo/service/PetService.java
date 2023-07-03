package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;

import java.util.List;

public interface PetService {
    PetDto addPet(PetDto petDto);
    List<PetDto> getAllPets();
    void delete(int id);

    void updatePet(int id, Pet petRequest);
}
