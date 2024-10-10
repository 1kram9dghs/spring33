package com.akram.livres.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.akram.livres.entities.Type;
import com.akram.livres.service.TypeService;

@RestController
@RequestMapping("/api/types")
@CrossOrigin
public class TypeRESTController {
	
	@Autowired
    TypeService typeService;
	
	@GetMapping
	public List<Type> getAllTypes() {
	return typeService.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public Type getProduitById(@PathVariable Long id) {
	return typeService.getType(id);
	 }
	
	@PostMapping
	public Type createProduit(@RequestBody Type livre) {
	return typeService.saveType(livre);
	}
	
	@PutMapping
	public Type updateProduit(@RequestBody Type type) {
	return typeService.updateType(type);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable Long id)
	{
		typeService.deleteTypeById(id);
	}

}
