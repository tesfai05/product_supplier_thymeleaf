package edu.mum.cs.cs425.SupplierRelationshipManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Product;
import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Supplier;
import edu.mum.cs.cs425.SupplierRelationshipManagement.service.IProductService;
import edu.mum.cs.cs425.SupplierRelationshipManagement.service.ISupplierService;


@Controller
public class ProductController {
	@Autowired
	private IProductService  productService;
	
	@Autowired
	private ISupplierService  supplierService;
	
	
	@GetMapping(value = { "/product/newProduct" })
	public String addNewProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("suppliers", supplierService.displaySuppliers());
		return "product/newProduct";
		
	}
	
	@PostMapping(value = { "/product/newProduct" })
	public String saveNewProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result) {
		model.addAttribute("product", product);
		if (result.hasErrors()) {

			return "product/newProduct";
		}

		productService.addNewPoduct(product);

		return "redirect:/product/list";

	}
	@GetMapping(value = { "product/list" })
	public String displayProducts(Model model) {
		List<Product> products = productService.displayProducts();
		model.addAttribute("products", products);
		model.addAttribute("productCount", products.size());
		
		return "product/list";
		
	}
	@GetMapping(value = "/editproduct/{id}")
	public String editProducts(@PathVariable Integer id, Model model) {
		Product product = productService.editPoduct(id);
		List<Supplier> suppliers=supplierService.displaySuppliers();
		if(product==null) {
			return "redirect:/product/list";
		}
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("product", product);
		return "product/newProduct";
		
	}
	
	@GetMapping(value = "/deleteproduct/{id}")
	public String deleteProduct(@PathVariable Integer id, Model model) {
		productService.deleteProduct(id);
		return "redirect:/product/list";
	}

}
