package com.example.restaurante.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAllergyRepository extends CrudRepository<ProductAllergy, Integer>{
}
