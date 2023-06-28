package pe.edu.cibertec.veterinaria.cliente.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.veterinaria.cliente.ms.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
	
	List<Pet> findAllByStatus(Short status);
	
	@Modifying
	@Transactional
	@Query("UPDATE Pet p SET p.status = 2 WHERE p.idPet = ?1")
	int disablePetById(Integer idPet);

}
