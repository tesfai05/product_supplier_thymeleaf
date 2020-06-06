package edu.mum.cs.cs425.SupplierRelationshipManagement.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Product;
import edu.mum.cs.cs425.SupplierRelationshipManagement.repository.IProductRepository;
import edu.mum.cs.cs425.SupplierRelationshipManagement.service.IProductService;

@Service
public class ProductServiceImp implements IProductService{
	@Autowired
	private IProductRepository  productRepository;
	
	@Override
	public Product addNewPoduct(Product product) {
		
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> displayProducts() {
		
		return productRepository.findAll();
	}
	
	@Override
	public Product editPoduct(Integer id) {
		Product product=productRepository.findById(id)
				.orElse(new Product());
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
		
	}

}
