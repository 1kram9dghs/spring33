package com.akram.livres.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.akram.livres.entities.Livre;
import com.akram.livres.service.LivreService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LivreRESTController {
	@Autowired
	LivreService livreService;
	
	@GetMapping
	public List<Livre> getAllLivres() {
	return livreService.getAllLivres();
	}
	
	@GetMapping("/{id}")
	public Livre getProduitById(@PathVariable Long id) {
	return livreService.getLivre(id);
	 }
	
	
	
	@PostMapping
	public Livre createProduit(@RequestBody Livre livre) {
	return livreService.saveLivre(livre);
	}
	
	@PutMapping
	public Livre updateProduit(@RequestBody Livre livre) {
	return livreService.updateLivre(livre);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLivre(@PathVariable Long id)
	{
		livreService.deleteLivreById(id);
	}
	
	@GetMapping("getByType/{id}")
	public List<Livre> getLivresByType(@PathVariable Long id) {
	return livreService.getLivresByTypeID(id);
	}
	
	@GetMapping("getByTitreContains/{titre}")
	public List<Livre> getLivresByType(@PathVariable String titre) {
	return livreService.getLivresByTitreContains(titre);
	}
	
	
	
	
}
