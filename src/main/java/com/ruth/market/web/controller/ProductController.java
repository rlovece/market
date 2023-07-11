package com.ruth.market.web.controller;

import com.ruth.market.domain.Product;
import com.ruth.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Product> getProduct (@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    /// como ya no retorno un Optinal, si lo encuentra, lo muestra con status ok, y sino status NOt-found 404.

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory (@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save (@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
    ///se puede usar OK. pero CREATED es más específico.

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete (@PathVariable("id") int productId){
        if (productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
