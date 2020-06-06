package edu.mum.cs.cs425.SupplierRelationshipManagement.service;

import java.util.List;

import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Product;

public interface IProductService {

	Product addNewPoduct(Product product);

	List<Product> displayProducts();

	Product editPoduct(Integer id);

	void deleteProduct(Integer id); 

}
