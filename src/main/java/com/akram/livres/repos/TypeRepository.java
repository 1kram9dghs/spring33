package com.akram.livres.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.akram.livres.entities.Type;

public interface TypeRepository extends JpaRepository<Type,Long>{
	
}
