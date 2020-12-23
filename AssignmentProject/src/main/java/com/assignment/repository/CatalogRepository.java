package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

	List<Catalog> findBySupplierIdAndSkuNameContaining(Long supplierId,String text);
	
}
