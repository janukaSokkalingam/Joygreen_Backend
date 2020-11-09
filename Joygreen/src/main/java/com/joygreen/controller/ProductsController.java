package com.joygreen.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joygreen.model.Products;
import com.joygreen.service.ProductsService;


@RestController
@RequestMapping ("/product")
public class ProductsController {
	@Autowired
	ProductsService productsService;
	

	@GetMapping
	public ResponseEntity< List<Products>> getAllProducts() {
		System.out.println("hellooo");
		 return productsService.getAllProduct ();
		
	}
	@PostMapping
	public ResponseEntity <Products> createproduct (@RequestBody Products products){
	   return productsService.createproduct(products);

     }
	@GetMapping("/{id}")
	  public  ResponseEntity <Products> getproductById(@PathVariable String id) {
		 return productsService.getproductById(id);
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<Products> updateproductById(@RequestBody Products products, @PathVariable String id) {
		return productsService.updateproductById(id,products);
		 
	 }
	
		
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus>  deleteproductById(@PathVariable String id) {
		 return productsService.ProductyById(id);
	 }
	 
	 @GetMapping("/page")
	    public ResponseEntity<Map<String, Object>> getAllProductInPage(
	    		@RequestParam(name = "pageNo", defaultValue = "0") int pageNo, 
	    		@RequestParam(name = "pageSize", defaultValue = "2") int pageSize, 
	    		@RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {
			return productsService.getAllProductInPage(pageNo, pageSize, sortBy);
		}

	 @GetMapping(params = "name")
		public ResponseEntity<List<Products>> searchproduct(@RequestParam String name){
		 return productsService.searchProduct(name);
		}
	 
	 


	 
	
}


