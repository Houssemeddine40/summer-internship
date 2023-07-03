package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.dto.PetDtoMapper;
import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PetServiceImp implements PetService{
   PetRepository petRepository ;
   PetDtoMapper petDtoMapper;






    @Override
    public PetDto addPet(PetDto petDto) {
        Pet pet=new Pet();
        pet.setName(petDto.name());
        pet.setAge(petDto.age());
        petRepository.save(pet);
        return petDto;
    }

    @Override
    public List<PetDto> getAllPets() {

        return petRepository.findAll()
                .stream()
                .map(petDtoMapper)
                .collect(Collectors.toList());
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
