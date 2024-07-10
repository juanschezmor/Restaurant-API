package com.example.restaurante.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")  // Reemplaza con el dominio de tu aplicación Angular

public class ProductsController {
    @Autowired
    private ProductsRepository ProductsRepository;

    //get all products with a specific category
    @GetMapping("/category-products")
    public Iterable<Product> getCategoryProducts(@RequestParam ProductType productType) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : ProductsRepository.findAll()
        ) {
            if (product.getProductType().equals(productType)) {
                products.add(product);
            }
        }
        return products;
    }


    @GetMapping("/product")
    public Product getProduct(@RequestParam int id) {
        return ProductsRepository.findById(id).get();
    }
}
