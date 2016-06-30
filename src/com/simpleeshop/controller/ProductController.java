package com.simpleeshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleeshop.entity.Product;
import com.simpleeshop.service.CategoryService;
import com.simpleeshop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping ("/editProduct")
	public String editProduct (Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "editProduct";
	}
	
	@RequestMapping ("/addProduct")
	public String addProduct (Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("addProduct") @Valid Product product) {
		productService.addProduct(product);
		model.addAttribute("successful", "true");
		return "redirect:/addProduct";
	}
}
