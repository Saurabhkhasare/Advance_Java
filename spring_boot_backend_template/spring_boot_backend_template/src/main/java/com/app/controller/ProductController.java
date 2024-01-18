package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public List<Product> getProduct() {
		return productService.getAllProds();
	}
}
