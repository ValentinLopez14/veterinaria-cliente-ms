package pe.edu.cibertec.veterinaria.cliente.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private Integer idPet; 
	
	@Column(name = "owner_id")
	private Integer ownerId;
	
	@Column(name = "species_id")
	private Integer speciesId; 
	
	@Column(name = "full_name")
	private String fullName;
	
	private String breed; 
	
	private String gender;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;  
	
	private String color; 
	
	private String allergies;
	
	private String note;  
	
	private Integer status = 1;
	
	

}
