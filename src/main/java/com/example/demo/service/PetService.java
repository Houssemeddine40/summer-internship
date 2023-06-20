package com.example.demo.service;

import com.example.demo.model.Pet;

import java.util.List;

public interface PetService {
    Pet addPet(Pet pet);
    List<Pet> getAllPets();
    void delete(int id);

    void updatePet(int id, Pet petRequest);
}
