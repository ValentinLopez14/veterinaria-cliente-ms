package pe.edu.cibertec.veterinaria.cliente.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Pet;
import pe.edu.cibertec.veterinaria.cliente.ms.repository.PetRepository;
import pe.edu.cibertec.veterinaria.cliente.ms.service.PetService;

@Service
public class PetServiceImpl implements PetService{

	@Autowired
	private PetRepository petRepository;
	
	@Override
	public Pet register(Pet pet) {
		
		return petRepository.save(pet);
	}

	@Override
	public Pet update(Pet pet) {
		
		return petRepository.save(pet);
	}

	@Override
	public List<Pet> listAll() {
		
		return petRepository.findAllByStatus((short) 1);
	}

	@Override
	public Pet findByPetById(Integer idPet) {
		
		return petRepository.findById(idPet).get();
	}

	@Override
	public Integer disablePetById(Integer idPet) {
		
		return petRepository.disablePetById(idPet);
	}

}
