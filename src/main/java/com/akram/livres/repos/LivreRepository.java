package com.akram.livres.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.akram.livres.entities.Livre;
@RepositoryRestResource(path = "rest")
public interface LivreRepository extends JpaRepository<Livre,Long> {
	List<Livre> findByTitre(String nom);
	List<Livre> findByTitreContains(String nom);
	List<Livre> findByTypeIdType(long id);
}
