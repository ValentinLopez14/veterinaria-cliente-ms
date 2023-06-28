package pe.edu.cibertec.veterinaria.cliente.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.veterinaria.cliente.ms.entity.Specie;

@Repository
public interface SpecieRepository extends JpaRepository<Specie, Integer>{

	List<Specie> findAllByStatus(Short status);
	
	@Modifying
	@Transactional
	@Query("UPDATE Specie e SET e.status = 2 WHERE e.idSpecie = ?1")
	int disableSpecieById(Integer idSpecie);
}
