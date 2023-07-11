package com.ruth.market.persistence.entity.mapper;

import com.ruth.market.domain.PurchaseItem;
import com.ruth.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring", uses = {ProdutMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target ="productId" ),
            @Mapping(source = "cantidad", target ="quantity" ),
            ///@Mapping(source = "total", target ="total" ), ///no es necesario pq se llaman igual
            @Mapping(source = "estado", target ="ative" )
    })
    PurchaseItem toPurchaseItem (ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
           @Mapping(target = "compra", ignore = true),
           @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto (PurchaseItem item);
}
