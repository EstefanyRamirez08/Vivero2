package com.egg.servicios;

//import com.egg.entidades.Empleado;
import com.egg.entidades.GamaProducto;
import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;
import java.util.List;  

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

            if (gama != null && gama.getIdgama() != 0) {  // Asegurar que getIdgama() existe en GamaProducto
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

    public void listarProductos() throws Exception {
        List<Producto> todosProductos = daoProducto.listarTodos();
        imprimirLista(todosProductos);
    }

    public void imprimirLista(List<Producto> listaRecibida) throws Exception {
        for (Producto unitariaProducto : listaRecibida) {
            System.out.println(unitariaProducto.getCodigoProducto() + " - " 
                + unitariaProducto.getNombre() + " - " 
                + unitariaProducto.getGama());
        }
    }

    public void imprimirProductosExcluyendo(int idGama) throws Exception {
        List<Producto> listaProductos = daoProducto.listarProductosExcluyendo(idGama);
        for (Producto producto : listaProductos) {
            System.out.println(producto.getIdProducto() + " - " + producto.getDescripcion());
        }
    }
    
}
