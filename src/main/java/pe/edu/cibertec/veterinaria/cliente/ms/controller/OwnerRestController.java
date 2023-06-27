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

import pe.edu.cibertec.veterinaria.cliente.ms.entity.Owner;
import pe.edu.cibertec.veterinaria.cliente.ms.service.OwnerService;
import pe.edu.cibertec.veterinaria.cliente.ms.util.Response;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OwnerRestController {
	
	private OwnerService ownerService;
	
	public OwnerRestController (OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@PostMapping
	public ResponseEntity<Response> registerOwner(@RequestBody Owner owner){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se registró correctamente");
			response.setBody(ownerService.register(owner));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al registrar, intente nuevamente");
			System.out.println("Error al intentar registrar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Response> updateOwner(@RequestBody Owner owner){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Se actualizó correctamente");
			response.setBody(ownerService.update(owner));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al actualizar, intente nuevamente");
			System.out.println("Error al intentar actualizar " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}
	
	
	@GetMapping
	public ResponseEntity<Response> listAllOwners(){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Lista de clientes");
			response.setBody(ownerService.listAll());
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al lstar los clientes, intente nuevamente");
			System.out.println("Error al intentar listar los clientes " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/{idOwner}")
	public ResponseEntity<Response> findOwnerById(@PathVariable("idOwner") Integer idOwner){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Cliente encontrado");
			response.setBody(ownerService.findByOwnerById(idOwner));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al buscar el cliente por ID, intente nuevamente");
			System.out.println("Error al intentar buscar el cliente por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

		
	}
	
	
	@PutMapping("/disable/{idOwner}")
	public ResponseEntity<Response> disableOwnerById(@PathVariable("idOwner") Integer idOwner){
		
		Response response = new Response();
		
		try {
			
			response.setMessage("Cliente desabilitado");
			response.setBody(ownerService.disableOwnerById(idOwner));
			
		} catch (Exception e) {
			
			response.setMessage("Ocurrio un error al desabilitar al cliente por ID, intente nuevamente");
			System.out.println("Error al intentar desabilitar el empleado por ID " + e.getCause());
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK); 
	
	}


}
















