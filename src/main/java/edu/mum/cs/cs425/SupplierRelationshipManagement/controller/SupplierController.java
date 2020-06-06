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
import edu.mum.cs.cs425.SupplierRelationshipManagement.model.Supplier;
import edu.mum.cs.cs425.SupplierRelationshipManagement.service.ISupplierService;

@Controller
public class SupplierController {
	@Autowired
	private ISupplierService  supplierService;
	
	
	@GetMapping(value = { "/supplier/newSupplier" })
	public String addNewSupplier(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "supplier/newSupplier";
		
	}
	
	@PostMapping(value = { "/supplier/newSupplier" })
	public String saveNewSupplier(Model model, @Valid @ModelAttribute("supplier") Supplier supplier, BindingResult result) {
		model.addAttribute("supplier", supplier);
		if (result.hasErrors()) {

			return "/supplier/newSupplier";
		}

		supplierService.addNewSupplier(supplier);

		return "redirect:/supplier/list";

	}
	@GetMapping(value = { "/supplier/list" })
	public String displaySuppliers(Model model) {
		List<Supplier> suppliers = supplierService.displaySuppliers();
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("supplierCount", suppliers.size());
		
		return "supplier/list";
		
	}
	
	@GetMapping(value = "/deletesupplier/{id}")
	public String deleteStudent(@PathVariable Integer id, Model model) {
		supplierService.deleteSupplier(id);
		return "redirect:/supplier/list";
	}
	
	@GetMapping(value = "/editsupplier/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Supplier supplier = supplierService.getSupplier(id);
		if(supplier==null) {
			return "redirect:/supplier/list";
		}
		model.addAttribute("supplier", supplier);
		return "supplier/newSupplier";
	}
	
}
