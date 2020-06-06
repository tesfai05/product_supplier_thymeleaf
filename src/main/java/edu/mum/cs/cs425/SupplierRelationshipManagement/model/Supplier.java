package edu.mum.cs.cs425.SupplierRelationshipManagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;
	@NotNull
	private Integer supplierNumber;
	@NotNull
	private String name;
	@NotNull
	private String contactPhoneNumber;
	@OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
	private List<Product> products;
	public Supplier() {
		
	}
	public Supplier(Integer supplierNumber, String name, String contactPhoneNumber) {
		this.supplierNumber = supplierNumber;
		this.name = name;
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(Integer supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return  name ;
	}
	
	

}
