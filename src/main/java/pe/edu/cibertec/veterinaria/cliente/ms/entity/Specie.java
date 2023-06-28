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
@Table(name = "species")
public class Specie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "species_id")
	private Integer idSpecie; 
	
	private String name; 
	
	private String gender;
	
	private String note;  
	
	private Integer status = 1; // 1: ACTIVO || 2: INACTIVO  

}
