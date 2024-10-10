package com.akram.livres.service;

import java.util.List;

import com.akram.livres.entities.Livre;

public interface LivreService {

	Livre saveLivre(Livre l);
	Livre updateLivre(Livre l);
	void deleteLivre(Livre l);
	void deleteLivreById(Long id);
	Livre getLivre(Long id);
	List<Livre> getAllLivres();
	List<Livre> getLivresByTypeID(Long id);
	List<Livre> getLivresByTitre(String titre);
	List<Livre> getLivresByTitreContains(String titre);
}
