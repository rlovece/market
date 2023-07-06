package com.ruth.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "compras_productos")
public class ComprasProducto {

    ///region Atributos
    @EmbeddedId /// se utiliza cuando la clave primaria es compuesta y está dada por otra clase
    private ComprasProductosPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn (name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn (name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    ///endregion

    ///region Getters y Setters

    public ComprasProductosPK getId() {
        return id;
    }

    public void setId(ComprasProductosPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    ///endregion



}
