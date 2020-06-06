package edu.mum.cs.cs425.SupplierRelationshipManagement.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Product;
import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Supplier;
import edu.mum.cs.cs425.SupplierRelationshipManagement.repository.ISupplierRepository;
import edu.mum.cs.cs425.SupplierRelationshipManagement.service.ISupplierService;

@Service
public class SupplierServiceImp implements ISupplierService{

	@Autowired
	private ISupplierRepository  supplierRepository;
	
	@Override
	public Supplier addNewSupplier(Supplier supplier) {
		
		return supplierRepository.save(supplier);
	}
	
	@Override
	public List<Supplier> displaySuppliers() {
		
		return supplierRepository.findAll();
	}

	@Override
	public void deleteSupplier(Integer id) {
		supplierRepository.deleteById(id);
		
	}

	@Override
	public Supplier getSupplier(Integer id) {
		
		return supplierRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("Not found"));
	}
}
