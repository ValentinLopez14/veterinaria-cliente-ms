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

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Pet;
import pe.edu.cibertec.veterinaria.cliente.ms.service.PetService;
import pe.edu.cibertec.veterinaria.cliente.ms.util.Response;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PetRestControler {
	
	private PetService petService;
	
	public PetRestControler(PetService petService) {
		this.petService = petService;
	}
	
	@PostMapping
	public ResponseEntity<Response> registerPet(@RequestBody Pet pet){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se registró correctamente");
			response.setBody(petService.register(pet));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al registrar, intente nuevamente");
			System.out.println("Error al intentar registrar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Response> updatePet(@RequestBody Pet pet){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se actualizó correctamente");
			response.setBody(petService.update(pet));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al actualizar, intente nuevamente");
			System.out.println("Error al intentar actualizar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@GetMapping
	public ResponseEntity<Response> listAllPets(){
		
		Response response = new Response();
		
		try {
			response.setMessage("Lista de mascotas");
			response.setBody(petService.listAll());
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al listar las mascotas, intente nuevamente");
			System.out.println("Error al intentar listar las mascotas " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/{idPet}")
	public ResponseEntity<Response> findPetById(@PathVariable("idPet") Integer idPet){
		
		Response response = new Response();
		 try {
			 
			 response.setMessage("Mascota encontrado");
			 response.setBody(petService.findByPetById(idPet));
			 
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al buscar la mascota por ID, intente nuevamente");
			System.out.println("Error al intentar buscar la mascota por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@PutMapping("/disable/{idPet}")
	public ResponseEntity<Response> disablePetById(@PathVariable("idPet") Integer idPet){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Mascota desabilitado");
			response.setBody(petService.disablePetById(idPet));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al desabilitar a la mascota por ID, intente nuevamente");
			System.out.println("Error al intentar desabilitar a la mascota por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK); 

	}
	
	

}
