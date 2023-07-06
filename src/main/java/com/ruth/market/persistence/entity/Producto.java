package com.ruth.market.persistence.entity;

import jakarta.persistence.*;

@Entity /// la anotación @Entity le da a entender a JAVA que mapea de una tabla.
@Table (name = "productos") /// la anotación @Table con name la debo poner porque la tabla tiene un nombre distinto
public class Producto {

    ///region Atributos
    @Id /// anotación para indicar que es la llave primaria simple
    @GeneratedValue (strategy = GenerationType.IDENTITY) /// Para indicar que es la clave que da identidad,
                                                         // así se genera automaticamente
    @Column (name = "id_producto") /// la anotación para indicar que columna pq el nombre es distinto
    private Integer idProducto;

    private String nombre;

    @Column (name = "id_categoria")
    private Integer idCategoria;

    @Column (name = "codigo_barras")
    private String codigoBarras;

    @Column (name = "precio_venta")
    private Double precioVenta;

    @Column (name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne //relacion muchos a uno
    @JoinColumn (name = "id_categoria", insertable = false, updatable = false) //busca la categoria por id
                                                                /// no se puede insertar ni modificar una cat
                                                                // desde un producto.
    private Categoria categoria;
    ///endregion

    ///region Getters y Setters

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    ///endregion

}
