package pe.edu.cibertec.veterinaria.cliente.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Owner;
import pe.edu.cibertec.veterinaria.cliente.ms.repository.OwnerRepository;
import pe.edu.cibertec.veterinaria.cliente.ms.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Override
	public Owner register(Owner owner) {
		
		return ownerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		
		return ownerRepository.save(owner);
	}

	@Override
	public List<Owner> listAll() {
		
		return ownerRepository.findAll();
	}

	@Override
	public Owner findByOwnerById(Integer idOwner) {
		
		return ownerRepository.findById(idOwner).get();
	}

	@Override
	public Integer disableOwnerById(Integer idOwner) {
		
		return ownerRepository.disableOwnerById(idOwner);
	}

}
