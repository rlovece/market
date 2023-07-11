package com.ruth.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable ///porque la vamos a embever en ComprasProducto
public class ComprasProductoPK implements Serializable {

    @Column (name = "id_compra")
    private Integer idCompra;

    @Column (name = "id_producto")
    private Integer idProducto;

    ///region Getters y Setters

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    ///endregion
}

