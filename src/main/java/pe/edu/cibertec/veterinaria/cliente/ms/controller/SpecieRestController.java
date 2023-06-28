package pe.edu.cibertec.veterinaria.cliente.ms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se registró correctamente");
			response.setBody(specieService.register(specie));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al registrar, intente nuevamente");
			System.out.println("Error al intentar registrar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public ResponseEntity<Response> updateSpecie(@RequestBody Specie specie){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se actualizó correctamente");
			response.setBody(specieService.update(specie));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al actualizar, intente nuevamente");
			System.out.println("Error al intentar actualizar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping
	public ResponseEntity<Response> listAllSpecies(){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Lista de Especies");
			response.setBody(specieService.listAll());
			
		} catch (Exception e) {
		
			response.setMessage("Ocurrio un error al lstar las especies, intente nuevamente");
			System.out.println("Error al intentar listar las especies " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping("/{idSpecie}")
	public ResponseEntity<Response> findSpecieById(@PathVariable("idSpecie") Integer idSpecie){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Especie encontrado");
			response.setBody(specieService.findBySpecieById(idSpecie));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al buscar la especie por ID, intente nuevamente");
			System.out.println("Error al intentar buscar la especie por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@PutMapping("/disable/{idSpecie}")
	public ResponseEntity<Response> disableSpecieById(@PathVariable("idSpecie") Integer idSpecie){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Especie desabilitado");
			response.setBody(specieService.disableSpecieById(idSpecie));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al desabilitar la especie por ID, intente nuevamente");
			System.out.println("Error al intentar desabilitar la especie por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK); 

	}

}
