package com.example.demo.service;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PetServiceImp implements PetService{
   PetRepository petRepository ;






    @Override
    public Pet addPet(Pet pet) {
        petRepository.save(pet);
        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void delete(int id) {
        boolean exists = petRepository.existsById(id);
        if (exists){
            petRepository.deleteById(id);
        }
    }

    @Transactional
    public void updatePet(int id, Pet petRequest) {

    if(petRepository.existsById(id)){
        Pet pet = petRepository.findById(id).get();
        pet.setName(petRequest.getName());
        pet.setAge(petRequest.getAge());

    }
    }


}
