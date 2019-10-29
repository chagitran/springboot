package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NoProductFoundException;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product findProductById(Integer pId) {
		if (pId == 101) {
			return new Product("101", "Laptop", 55000.00);
		} else {
			throw new NoProductFoundException("No product found");
		}
	}

}
