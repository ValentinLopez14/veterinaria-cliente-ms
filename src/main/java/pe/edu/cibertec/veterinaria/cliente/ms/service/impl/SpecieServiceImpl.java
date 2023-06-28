package pe.edu.cibertec.veterinaria.cliente.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Specie;
import pe.edu.cibertec.veterinaria.cliente.ms.repository.SpecieRepository;
import pe.edu.cibertec.veterinaria.cliente.ms.service.SpecieService;

@Service
public class SpecieServiceImpl implements SpecieService{

	@Autowired
	private SpecieRepository specieRepository;
	
	@Override
	public Specie register(Specie specie) {
		
		return specieRepository.save(specie);
	}

	@Override
	public Specie update(Specie specie) {
		
		return specieRepository.save(specie);
	}

	@Override
	public List<Specie> listAll() {
		
		return specieRepository.findAllByStatus((short) 1);
	}

	@Override
	public Specie findBySpecieById(Integer idSpecie) {
		
		return specieRepository.findById(idSpecie).get();
	}

	@Override
	public Integer disableSpecieById(Integer idSpecie) {
		
		return specieRepository.disableSpecieById(idSpecie);
	}

}
