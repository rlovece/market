package com.ruth.market.web.controller;

import com.ruth.market.domain.Product;
import com.ruth.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all") //se utiliza GetMapping para obtener info
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/productId/{id}") ///agregando el @PathVariable logro que colocando el id en URL se ejecute el método
    public Optional<Product> getProduct (@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory (@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save (@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete (@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
