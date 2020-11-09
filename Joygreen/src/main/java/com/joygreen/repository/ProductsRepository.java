package com.joygreen.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.joygreen.model.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products,String>{

	@Query(" {$or:[{'name' : {$regex: ?0, $options: 'i'}}, {'price': {$regex: ?0, $options: 'i'}} ]}")
	List<Products> searchProduct(String name);
}
