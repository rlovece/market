package com.ruth.market.persistence;

import com.ruth.market.domain.Product;
import com.ruth.market.domain.repository.ProductRepository;
import com.ruth.market.persistence.crud.ProductoCrudRepository;
import com.ruth.market.persistence.entity.Producto;
import com.ruth.market.persistence.entity.mapper.ProdutMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository /// para indicarle a Spring que está clase se encarga del manejo de la base de datos.
              /// tb podría usar @Component para indicar que es un componente , pero @Repository es más especifico
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    ProdutMapper produtMapper;

    /**
     * <h2>Listar productos</h2>
     * Metodo para listar todos los productos de la basee datos.
     *
     * @return Lista de productos
     */
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
                                        ///lo debe castear para obtener la lista
        return produtMapper.toProducts(productos);
    }



    /**
     * <h2>Listar productos por categoria</h2>
     * Metodo para listar todos los productos de la basee datos.
     *
     * @return Lista de productos
     */
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(produtMapper.toProducts(productos));
    }

    /**
     * <h2>Listar productos escasos</h2>
     * Metodo para listar todos los productos de la basee datos.
     *
     * @return Lista de productos
     */
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndAndEstado(quantity, true);
        return productos.map(producto -> produtMapper.toProducts(producto));
                    /// mapea cada producto en Optional
    }

    /**
     * <h2>Producto por Id</h2>
     * Metodo para buscar un producto por id
     *
     * @return producto buscado, si existe
     */
    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(producto1 -> produtMapper.toProduct(producto1));
    }


    /**
     * <h2>Guardar Producto</h2>
     * Metodo agregar producto a la base de datos.
     *
     * @return el producto
     */
    @Override
    public Product save(Product product) {
        Producto producto = produtMapper.toProducto(product);
        return produtMapper.toProduct(productoCrudRepository.save(producto));
    }

    /**
     * <h2>Eliminar Producto por Id</h2>
     * Metodo eliminar producto a la base de datos.
     *
     */
    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
