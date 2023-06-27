package pe.edu.cibertec.veterinaria.cliente.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Entity
@Table(name = "owners")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "owner_id")
	private Integer idOwner;
	
	private String names;
	
	@Column(name = "father_last_name")
	private String fatherLastName; 
	
	@Column(name = "mother_last_name")
	private String motherLastName; 
	
	@Column(name = "document_number")
	private String documentNumber;  
	
	private String gender;   
	
	private String direction;
	
	private String email; 
	
	private String cellphone; 
	
	private String note;  
	
	private Integer status = 1; // 1: ACTIVO || 2: INACTIVO          

}
