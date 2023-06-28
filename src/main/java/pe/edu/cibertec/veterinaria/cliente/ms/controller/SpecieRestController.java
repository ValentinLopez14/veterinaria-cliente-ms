package pe.edu.cibertec.veterinaria.cliente.ms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Specie;
import pe.edu.cibertec.veterinaria.cliente.ms.service.SpecieService;
import pe.edu.cibertec.veterinaria.cliente.ms.util.Response;

@RestController
@RequestMapping("/specie")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SpecieRestController {
	
	private SpecieService specieService;
	
	public SpecieRestController (SpecieService specieService) {
		this.specieService = specieService;
	}
	
	
	@PostMapping
	public ResponseEntity<Response> registerSpecie(@RequestBody Specie specie){
		return null;
	}
	
	
	
	
	
	

}
