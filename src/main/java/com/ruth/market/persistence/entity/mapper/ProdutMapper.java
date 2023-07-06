package com.ruth.market.persistence.entity.mapper;

import com.ruth.market.domain.Product;
import com.ruth.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
                        /// agrego el uses pq dentro de Producto tengo una categoria que tb debe ser convertida
public interface ProdutMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    Product toProduct (Producto producto);

    ///Acá puedo convertir una lista, no debo aclarar todos los atributos de nuevo.
    List<Product> toProducts (List<Producto> productos);

    ///la inversa
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto (Product product);
}
