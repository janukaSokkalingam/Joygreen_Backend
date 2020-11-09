package com.joygreen.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.joygreen.model.Products;
import com.joygreen.repository.ProductsRepository;


@Service
public class ProductsService {
	@Autowired
	ProductsRepository productsRepository;
	
	

	public ResponseEntity< List<Products>> getAllProduct () {
		try {
			List<Products> product= productsRepository.findAll();
			if (product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<> (product,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}



	public ResponseEntity<Products> createproduct(Products products) {
		try {
			Products pou = productsRepository.insert(products);
			return new ResponseEntity<>(pou,HttpStatus.CREATED);
		 }catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
}



	public ResponseEntity<Products> getproductById(String id) {
		Optional<Products> poultry =productsRepository.findById(id);
		if (poultry.isPresent()) {
			return new ResponseEntity<>(poultry.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}



	public ResponseEntity<Products> updateproductById(String id, Products products) {
		Optional<Products> oldProducts = productsRepository.findById(id);
		if (oldProducts.isPresent()) {
			Products _products = oldProducts.get();
			_products.setName(products.getName());
			_products.setDescribtion(products.getDescribtion());
			_products.setPrice(products.getPrice());
			_products.setUrl(products.getUrl());
			
			
			return new ResponseEntity<> (productsRepository.save(_products),HttpStatus.OK);
			}else {
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			}
	}



	public ResponseEntity<HttpStatus> ProductyById(String id) {
		try {
			productsRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	public ResponseEntity<Map<String, Object>> getAllProductInPage(int pageNo, int pageSize, String sortBy) {
		try {
			Map<String, Object> response = new HashMap<>();
		    Sort sort = Sort.by(sortBy);
			Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		    Page<Products> page = productsRepository.findAll(pageable);
		    response.put("data", page.getContent());
		    response.put("Total no of pages", page.getTotalPages());
		    response.put("TotalNoOfElements", page.getTotalElements());
		    response.put("Current page no", page.getNumber());
		    
		    return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}



	}



	public ResponseEntity<List<Products>> searchProduct(String name) {
		try {
			List<Products> products = productsRepository.searchProduct(name);
			
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		}catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}


