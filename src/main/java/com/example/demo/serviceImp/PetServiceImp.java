package com.example.demo.serviceImp;

import com.example.demo.dto.PersonDtoMapper;
import com.example.demo.dto.PetDto;
import com.example.demo.dto.PetDtoMapper;
import com.example.demo.model.Person;
import com.example.demo.model.Pet;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.PetService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@AllArgsConstructor
@Transactional
@Service
public class PetServiceImp implements PetService {
    private final PetRepository petRepository ;
    private final PetDtoMapper petDtoMapper;
    private final PersonDtoMapper personDtoMapper;
    private final PersonRepository personRepository;






    @Override
    public PetDto addPet(PetDto petDto) {
        Pet pet=new Pet();
        pet.setName(petDto.name());
        pet.setAge(petDto.age());
        //Person person =personRepository.findById(petDto.person().getId()).get();
        System.out.println(petDto.person());
        pet.setPerson(petDto.person());
        petRepository.save(pet);
        return petDto;
    }

    @Override
    public List<PetDto> getAllPets() {
        List<PetDto> listPets = petRepository.findAll()
                .stream()
                .map(pet -> {
                    return petDtoMapper.apply(pet);
                })
                .toList();
        return listPets;
    }
//.forEach(petDto -> personDtoMapper.apply(petDto.person()))
    @Override
    public void delete(int id) {
        boolean exists = petRepository.existsById(id);
        if (exists){
            petRepository.deleteById(id);
        }
    }

    @Transactional
    public void updatePet(int id, Pet petRequest) {
    if(petRepository.findById(id).isPresent()){
        Pet pet = petRepository.findById(id).get();
        pet.setName(petRequest.getName());
        pet.setAge(petRequest.getAge());
        pet.setPerson(petRequest.getPerson());


    }
    }


}
