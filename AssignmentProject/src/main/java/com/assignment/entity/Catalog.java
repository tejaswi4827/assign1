package com.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Catalog  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skuCode;
	
	@NotBlank(message = "sku name cannot be null")
	private String skuName;
	
	@Lob
	private String description;
	
	@NotBlank(message = "brand name cannot be null")
	private String brandName;
	
	@Lob
	private String brandDescription;
	
	@NotNull
	private Long supplierId;
	
	
	public Catalog() {
	}


	public Long getSkuCode() {
		return skuCode;
	}


	public void setSkuCode(Long skuCode) {
		this.skuCode = skuCode;
	}


	public String getSkuName() {
		return skuName;
	}


	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public String getBrandDescription() {
		return brandDescription;
	}


	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}


	public Long getSupplierId() {
		return supplierId;
	}


	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}


	@Override
	public String toString() {
		return "Catalog [skuCode=" + skuCode + ", skuName=" + skuName + ", description=" + description + ", brandName="
				+ brandName + ", brandDescription=" + brandDescription + ", supplierId=" + supplierId + "]";
	}
	
	
	
	
	
	
}
