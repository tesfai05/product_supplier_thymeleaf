package edu.mum.cs.cs425.SupplierRelationshipManagement.service;

import java.util.List;

import org.springframework.ui.Model;

import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Product;
import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Supplier;

public interface ISupplierService {

	Supplier addNewSupplier(Supplier supplier);
	List<Supplier> displaySuppliers();
	void deleteSupplier(Integer id);
	Supplier getSupplier(Integer id);
	

}
