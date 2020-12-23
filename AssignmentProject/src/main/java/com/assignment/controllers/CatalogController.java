package com.assignment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Catalog;
import com.assignment.repository.CatalogRepository;

@RestController
@RequestMapping("api/catalog")
public class CatalogController {

	
	private CatalogRepository catalogRepo;
	
	@Autowired
	public CatalogController(CatalogRepository catalogRepo) {
		this.catalogRepo = catalogRepo;
	}

	/**
	 * a post method to add new catalog.
	 * 
	 * @param catalog a Catalog class object
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<String> createCatalog(@Valid @RequestBody Catalog catalog) {
		try {
			catalogRepo.save(catalog);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an error occured");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("catalog added successfully");
	}
	
	/**
	 * a get method to find all the catalogs having specific text in skuname
	 * and have specific csupplier id.
	 * 
	 * @param id supplier_id
	 * @param text sku name as text
	 * @return
	 */
	@GetMapping("/find/{supplierId}/{text}")
	public ResponseEntity<List<Catalog>> findCatalog(@Valid @PathVariable("supplierId") Long id, @PathVariable("text") String text) {
		List<Catalog> findAll = catalogRepo.findBySupplierIdAndSkuNameContaining(id, text);
		return ResponseEntity.status(HttpStatus.FOUND).body(findAll);
	}
	
}
