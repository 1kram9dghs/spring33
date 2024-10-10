package com.akram.livres.service;

import java.util.List;

import com.akram.livres.entities.Type;



public interface TypeService {
	Type saveType(Type t);
	Type updateType(Type t);
	void deleteType(Type t);
	void deleteTypeById(Long id);
	Type getType(Long id);
	List<Type> getAllTypes();
}
