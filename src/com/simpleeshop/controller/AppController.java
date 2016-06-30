package com.simpleeshop.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.simpleeshop.entity.Category;
import com.simpleeshop.entity.Product;
import com.simpleeshop.service.CategoryService;
import com.simpleeshop.service.ProductService;

@Controller
public class AppController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	// @Autowired
	// private OrderService orderService;

	@RequestMapping("/")
	public String list(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("products", productService.getAllProducts());
		return "main";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String category) {
		//List<Product> products = productService.getProductsByCategory(category);
		/*TODO release exception
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}*/
		model.addAttribute("categories", categoryService.getAll());
		//model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping("/editCategories")
	public String editCategories(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "editCategories";
	}

	@RequestMapping(value = "/editCategories", method = RequestMethod.POST, params = "update=Update")
	public String updateCategories(@RequestParam("id") Long id, @RequestParam("name") String name) {
		categoryService.update(new Category(id, name, true)); //TODO need show
		return "redirect:/editCategories";
	}

	@RequestMapping(value = "/editCategories", method = RequestMethod.POST, params = "add=Add")
	public String addCategories() {
		categoryService.add();
		return "redirect:/editCategories";
	}

	@RequestMapping(value = "/editCategories", method = RequestMethod.POST, params = "delete=Delete")
	public String deleteCategories(@RequestParam("id") Long id) {
		categoryService.delete(id);
		return "redirect:/editCategories";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}

		String[] suppressedFields = result.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		/*
		MultipartFile productImage = productToBeAdded.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"resources\\images\\"+productToBeAdded.getProductId() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

		*/
	   	productService.addProduct(productToBeAdded);
		return "redirect:/products";
	}
	/*
	 * =========================================================================
	 * =====
	 */
	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") Long productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	// public String processAddNewProductForm(@ModelAttribute("newProduct")
	// Product productToBeAdded, BindingResult result)
	/*
	 * @RequestMapping("/order/P1234/2") public String process() {
	 * orderService.processOrder("P1234", 2); return "redirect:/products"; }
	 */
}
