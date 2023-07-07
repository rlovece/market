package com.ruth.market.domain.service;

import com.ruth.market.domain.Product;
import com.ruth.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //tb podría ser @Component pero más específico Service.
/// Este servicio va a inyectar el ProdcutRepositoria
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
        /// ProductRepository es una interfaz y no tiene notación de spring pero lo que se va a impleentar
        // es ProductoRepository que sí tiene la notación de spring.

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct (int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory (int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save (Product product){
        return productRepository.save(product);
    }

    public boolean delete (int productId){
        try {
            productRepository.delete(productId);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
        /* es Valido pero lo anterior es más optimo.
        if (getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else {
            return false;
        }*/
    }
}
