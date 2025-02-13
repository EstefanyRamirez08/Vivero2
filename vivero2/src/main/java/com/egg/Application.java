package com.egg;

import com.egg.servicios.OficinaServicio;
import com.egg.servicios.ClienteServicio;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.EmpleadoServicio;
import com.egg.entidades.GamaProducto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        EntityManager em = emf.createEntityManager();

        
         // Instanciar las clases para acceder a sus métodos
        OficinaServicio oficinaServicio = new OficinaServicio();
        
        ClienteServicio clienteServicio = new ClienteServicio();

         GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();
         EmpleadoServicio empleadoServicio = new EmpleadoServicio();  


        // // Llamar al método del servicio para crear una nueva oficina
        oficinaServicio.crearOficina("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111", "CP5000");

    

        // // llamar al metodo cliente servicio para crear un cliente
        clienteServicio.crearCliente("Juan", "Mendoza", 12345678, "CP5000", "11111111", 1, 10000.00, "Juan Perez", "Juan Perez", "Argentina", "Mendoza", "12345678");

         // llamar al metodo gama producto servicio para crear un gama producto
        gamaProductoServicio.crearGamaProducto("Descripcion html", "Descripcion texto", "gama", "imagen");
    


        // llamar al metodo gama producto servicio para buscar un gama producto
        GamaProducto gamaProducto = gamaProductoServicio.buscarGamaProductoPorId(1);

         // Imprimir el resultado si se encontró la gama de productos
         if (gamaProducto != null) {
            System.out.println("Gama de Producto encontrada: " + gamaProducto);

            // Llamar el metodo actualizarGamaProducto para actualizar la gama de producto

            try {
                gamaProductoServicio.actualizarGamaProducto(1, "Nueva Gama", "Nueva Descripción HTML", "Nueva Descripción Texto", "Nueva Imagen");
                System.out.println("Gama de Producto actualizada con éxito.");
            } catch (Exception e) {
                System.out.println("Error al actualizar la Gama de Producto: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró la gama de productos con ID: 1.");
        }

        // llamar al metodo empleado servicio para eliminar un empleado

          // Llamar al método para eliminar un empleado
          int idEmpleadoAEliminar = 2;  // ID del empleado a eliminar (ajústalo según tu BD)
          try {
              empleadoServicio.eliminarEmpleado(idEmpleadoAEliminar);
              System.out.println("Empleado con ID " + idEmpleadoAEliminar + " eliminado con éxito.");
          } catch (Exception e) {
              System.out.println("Error al eliminar el empleado: " + e.getMessage());
          }

        }
    }


    
