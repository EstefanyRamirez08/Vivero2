package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

public class ProductoServicio {
    private final ProductoDAO daoProducto;

    public ProductoServicio() {
        this.daoProducto = new ProductoDAO();
    }
    public void guardarProducto(String nombre, String descripcion, double precioVenta, GamaProducto gama) {
        try {
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecioVenta((int) precioVenta);
    
            if (gama != null && gama.getIdgama() != 0) {  // Usar getIdgama() en lugar de getIdGama()
                producto.setGama(gama);
            } else {
                System.out.println("Advertencia: La gama del producto no es válida.");
            }
    
            daoProducto.guardarProducto(producto);
            System.out.println("Producto guardado correctamente");
    
        } catch (Exception e) {
            System.out.println("No se guardó el producto de manera correcta: " + e.getMessage());
        }
    }
}