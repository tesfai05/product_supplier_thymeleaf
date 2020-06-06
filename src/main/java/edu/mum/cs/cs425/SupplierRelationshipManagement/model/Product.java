package edu.mum.cs.cs425.SupplierRelationshipManagement.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@NotNull
	private Long productNumber;
	@NotNull
	private String name;
	@NotNull
	private Double unitPrice;
	@NotNull
	private int  quantityInStock;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateSupplied;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	public Product() {
	
	}
	public Product(Long productNumber, String name, Double unitPrice, int quantityInStock, LocalDate dateSupplied) {
		this.productNumber = productNumber;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplied = dateSupplied;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Long getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public LocalDate getDateSupplied() {
		return dateSupplied;
	}
	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}
	


}
