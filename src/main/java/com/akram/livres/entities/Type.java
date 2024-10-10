package com.akram.livres.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idType;
	private String nomType;
	private String descriptionType;
	@JsonIgnore
	@OneToMany(mappedBy = "type")
	private List<Livre> types;

	
	
	

	

	public Type(String nomType, String descriptionType, List<Livre> types) {
		
		this.nomType = nomType;
		this.descriptionType = descriptionType;
		this.types = types;
	}
	public Type(String nomType, String descriptionType) {
		
		this.nomType = nomType;
		this.descriptionType = descriptionType;
		
	}



	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}

	public List<Livre> getTypes() {
		return types;
	}

	public void setTypes(List<Livre> types) {
		this.types = types;
	}
	
	
}
