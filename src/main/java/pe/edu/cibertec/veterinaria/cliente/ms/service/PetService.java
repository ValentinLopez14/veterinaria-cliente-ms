package pe.edu.cibertec.veterinaria.cliente.ms.service;

import java.util.List;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Pet;

public interface PetService {
	
	Pet register(Pet pet);
	
	Pet update(Pet pet);
	
	List<Pet> listAll();
	
	Pet findByPetById(Integer idPet);
	
	Integer disablePetById(Integer idPet);

}
