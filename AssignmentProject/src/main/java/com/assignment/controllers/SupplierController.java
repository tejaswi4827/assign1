package com.assignment.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Supplier;
import com.assignment.repository.SupplierRepository;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {
		
	private SupplierRepository supplierRepo;

	
	@Autowired
	public SupplierController(SupplierRepository supplierRepo) {
		this.supplierRepo = supplierRepo;
	}



	/**
	 * a post method to add new supplier.
	 * 
	 * @param sup an object of {@link Supplier} class
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<String> createSupplier(@Valid @RequestBody Supplier sup) {
		try {
		supplierRepo.save(sup);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an error occured");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("supplier added successfully");
	}
	

}
