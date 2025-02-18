package com.egg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "codigo_producto", length = 255)
    private String codigoProducto;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "dimensiones", length = 255)
    private String dimensiones;

    @Column(name = "proveedor", length = 255)
    private String proveedor;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "cantidad_en_stock")
    private int cantidadEnStock;

    @Column(name = "precio_venta")
    private double precioVenta;  

    @Column(name = "precio_proveedor")
    private double precioProveedor; 

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;

    public Producto() {}

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public double getPrecioVenta() {  
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) { 
        this.precioVenta = precioVenta;
    }

    public double getPrecioProveedor() { 
        return precioProveedor;
    }

    public void setPrecioProveedor(double precioProveedor) { 
        this.precioProveedor = precioProveedor;
    }

    public GamaProducto getGama() {
        return gamaProducto;
    }

    public void setGama(GamaProducto gama) {
        this.gamaProducto = gama;
    }
}
