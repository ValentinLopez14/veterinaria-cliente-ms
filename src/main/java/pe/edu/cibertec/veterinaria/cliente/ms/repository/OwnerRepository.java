package pe.edu.cibertec.veterinaria.cliente.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.veterinaria.cliente.ms.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{
	
	List<Owner> findAllByStatus(Short status);
	
	@Modifying
	@Transactional
	@Query("UPDATE Owner o SET o.status = 2 WHERE o.idOwner = ?1")
	int disableOwnerById(Integer idOwner);

}
