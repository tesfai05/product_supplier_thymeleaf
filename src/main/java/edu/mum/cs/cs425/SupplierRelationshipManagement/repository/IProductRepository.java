package edu.mum.cs.cs425.SupplierRelationshipManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
