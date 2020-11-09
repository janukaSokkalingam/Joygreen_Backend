package com.joygreen.repository;

import org.springframework.stereotype.Repository;

import com.joygreen.model.ERole;
import com.joygreen.model.Role;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);

}
