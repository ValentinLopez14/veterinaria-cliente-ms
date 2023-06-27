package pe.edu.cibertec.veterinaria.cliente.ms.service;

import java.util.List;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Owner;

public interface OwnerService {
	
	Owner register(Owner owner);
	
	Owner update(Owner owner);
	
	List<Owner> listAll();
	
	Owner findByOwnerById(Integer idOwner);
	
	Integer disableOwnerById(Integer idOwner);

}
