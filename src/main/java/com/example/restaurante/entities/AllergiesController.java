package com.example.restaurante.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AllergiesController {

    @Autowired
    private AllergiesRepository AllergiesRepository;

    @Autowired
    private ProductAllergyRepository ProductAllergyRepository;

    //Get all allergies from a product
    @GetMapping("/product-allergies-id")
    public Iterable<ProductAllergy> getProductAllergiesId(@RequestParam int productId){
        ArrayList<ProductAllergy> allergies = new ArrayList<>();

        for (ProductAllergy allergy :ProductAllergyRepository.findAll()
             ) {
            if (allergy.getProductId() == productId){
                allergies.add(allergy);
            }

        }
        return allergies;
    }

    //Get allergy name from id
    @GetMapping("/allergy-name")
    public String getAllergyName(@RequestParam int allergyId){
        return AllergiesRepository.findById(allergyId).get().getAllergyName();
    }
    //esto es una cosa que he probado para poder conectar la base de datos en el angular
    @GetMapping("/product-allergies")
    public ResponseEntity<List<String>> getProductAllergies(@RequestParam int productId) {
        List<String> allergiesList = new ArrayList<>();

        for (ProductAllergy allergy : ProductAllergyRepository.findAll()) {
            if (allergy.getProductId() == productId) {
                String allergyName = AllergiesRepository.findById(allergy.getAllergyId()).orElse(null).getAllergyName();
                if (allergyName != null) {
                    allergiesList.add(allergyName);
                }
            }
        }

        return ResponseEntity.ok(allergiesList);
    }

}
