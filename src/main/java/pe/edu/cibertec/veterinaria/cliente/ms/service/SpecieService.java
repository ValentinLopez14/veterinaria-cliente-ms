package pe.edu.cibertec.veterinaria.cliente.ms.service;

import java.util.List;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Specie;

public interface SpecieService {
	
	Specie register(Specie specie);
	
	Specie update(Specie specie);
	
	List<Specie> listAll();
	
	Specie findBySpecieById(Integer idSpecie);
	
	Integer disableSpecieById(Integer idSpecie);

}
