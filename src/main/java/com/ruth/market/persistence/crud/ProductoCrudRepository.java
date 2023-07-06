package com.ruth.market.persistence.crud;

import com.ruth.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
                                                   //debemos indicar clase y tipo de clave primaria

    /**
     * <h2>Filtro por categoría</h2>
     *
     * return lista de productos por categoria.
     */
    List<Producto> findByIdCategoria(int idCategoria);
    ///esto tb se podría hacer de manera nativa con el @Query


    /**
     * <h2>Filtro por categoría ordenado</h2>
     *
     * return lista de productos por categoria ordenado por nombre.
     */
    List<Producto> findByIdCategoriaOOrderByNombre(int idCategoria);

    /**
     * <h2>Filtro por cantidad stock menor que y estado</h2>
     *
     */
    Optional<List<Producto>> findByCantidadStockLessThanAndAndEstado (int cantidadStock, boolean estado);

}
