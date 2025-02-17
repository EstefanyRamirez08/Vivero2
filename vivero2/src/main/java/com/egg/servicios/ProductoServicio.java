package com.egg.servicios;

import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

public class ProductoServicio {
    private final ProductoDAO daoProducto;

    public ProductoServicio() {
        this.daoProducto = new ProductoDAO();
    }

    public void guardarProducto(int idProducto, String nombre, String descripcion, double precioVenta) {
        try {
            Producto producto = new Producto();
            producto.setIdProducto(idProducto);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecioVenta((int) precioVenta); // Convertimos a int para evitar errores

            daoProducto.guardarProducto(producto);
            System.out.println("Producto guardado correctamente");

        } catch (Exception e) {
            System.out.println("No se guardó el producto de manera correcta: " + e.getMessage());
        }
    }
}
