package com.egg;

import com.egg.servicios.*;
import com.egg.entidades.Cliente;
import com.egg.entidades.GamaProducto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static OficinaServicio oficinaServicio;
    private static ClienteServicio clienteServicio;
    private static GamaProductoServicio gamaProductoServicio;
    private static EmpleadoServicio empleadoServicio;
    private static PedidoServicio pedidoServicio;
    private static PagoServicio pagoServicio;
    private static ProductoServicio productoServicio;
    private static DetallePedidoServicio detallePedidoServicio;

    public static void main(String[] args) {
        inicializarServicios();

        try {
            probarOficinaServicio();
            probarClienteServicio();
            probarGamaProductoServicio();
            probarEmpleadoServicio();
            probarProductoServicio();
            probarPedidoServicio();
            probarPagoServicio();
            probarDetallePedidoServicio();
        } catch (Exception e) {
            System.out.println("Error en la ejecución: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }

        System.out.println("Todas las pruebas han finalizado.");
    }

    private static void inicializarServicios() {
        emf = Persistence.createEntityManagerFactory("ViveroPU");
        em = emf.createEntityManager();

        oficinaServicio = new OficinaServicio();
        clienteServicio = new ClienteServicio();
        gamaProductoServicio = new GamaProductoServicio();
        empleadoServicio = new EmpleadoServicio();
        pedidoServicio = new PedidoServicio();
        pagoServicio = new PagoServicio();
        productoServicio = new ProductoServicio();
        detallePedidoServicio = new DetallePedidoServicio();
    }

    private static void probarOficinaServicio() {
        System.out.println("Probando OficinaServicio...");
        oficinaServicio.crearOficina("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111", "CP5000");
        System.out.println("Oficina creada con éxito.\n");
    }

    private static void probarClienteServicio() {
        System.out.println("Probando ClienteServicio...");
        clienteServicio.crearCliente("Juan", "Mendoza", 12345678, "CP5000", "11111111", 1, 10000.00, "Juan Perez",
                "Juan Perez", "Argentina", "Mendoza", "12345678");
        System.out.println("Cliente creado con éxito.\n");
    }

    private static void probarGamaProductoServicio() {
        System.out.println("Probando GamaProductoServicio...");
        gamaProductoServicio.crearGamaProducto("Descripcion html", "Descripcion texto", "gama", "imagen");

        GamaProducto gamaProducto = gamaProductoServicio.buscarGamaProductoPorId(1);
        if (gamaProducto != null) {
            System.out.println("Gama de Producto encontrada: " + gamaProducto);
            try {
                gamaProductoServicio.actualizarGamaProducto(1, "Nueva Gama", "Nueva Descripción HTML",
                        "Nueva Descripción Texto", "Nueva Imagen");
                System.out.println("Gama de Producto actualizada con éxito.");
            } catch (Exception e) {
                System.out.println("Error al actualizar la Gama de Producto: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró la gama de productos con ID: 1.");
        }
        System.out.println();
    }

    private static void probarEmpleadoServicio() {
        System.out.println("Probando EmpleadoServicio...");
        int idEmpleadoAEliminar = 2;
        try {
            empleadoServicio.eliminarEmpleado(idEmpleadoAEliminar);
            System.out.println("Empleado con ID " + idEmpleadoAEliminar + " eliminado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }
        System.out.println();
    }

    private static void probarProductoServicio() {
        System.out.println("Probando ProductoServicio...");
        // Buscar una GamaProducto existente
        GamaProducto gamaProducto = gamaProductoServicio.buscarGamaProductoPorId(1);
        if (gamaProducto != null) {
            // Llamar a guardarProducto con los parámetros correctos
            productoServicio.guardarProducto("Maceta de barro", "Maceta artesanal", 20.50, gamaProducto);
            System.out.println("Producto guardado con éxito.\n");
        } else {
            System.out.println("Error: No se encontró la GamaProducto con ID 1.");
        }
    }

    private static void probarPedidoServicio() {
        System.out.println("Probando PedidoServicio...");
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        pedidoServicio.guardarPedido(1, 1001, "Pedido especial", "Pendiente", cliente);
        System.out.println("Pedido guardado con éxito.\n");
    }

    private static void probarPagoServicio() {
        System.out.println("Probando PagoServicio...");
        pagoServicio.guardarPago(1, "Tarjeta", "TXN12345", 100.00, 1);
        System.out.println("Pago guardado con éxito.\n");
    }

    private static void probarDetallePedidoServicio() {
        System.out.println("Probando DetallePedidoServicio...");
        detallePedidoServicio.guardarDetallePedido(1, 1, 20.50, 2);
        System.out.println("Detalle de pedido guardado con éxito.\n");
    }

    private static void cerrarRecursos() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }

        // Imprimir lista de oficinas
        System.out.println("**********************************************");
        System.out.println("             LISTA DE OFICINAS               ");
        System.out.println("**********************************************");
        System.out.println("ID oficina   |  Ciudad  Oficina   |   Pais oficina");
        oficinaServicio.listarOficinas();

        // Imprimir lista de Clientes por ciudad 
        System.out.println("**********************************************");
        System.out.println("             LISTA DE CLIENTES               ");
        System.out.println("**********************************************");
        System.out.println(" Nombre Cliente   | Apellido Contacto  | Ciudad Cliente ");
        System.out.println("------------------------------------------------------");

        // Llamar al servicio para listar los empleados por oficina
        //clienteServicio.listarClientes();

        // Imprimir lista de Empleados por Oficina
        System.out.println("**********************************************");
        System.out.println("             LISTA DE EMPLEADOS OFICINAS               ");
        System.out.println("**********************************************");
        System.out.println(" ID Empleado  |  Nombre Empleado | ID Oficina ");
        System.out.println("------------------------------------------------------");
        
        empleadoServicio.listarEmpleadosOficinas();

        // Imprimir lista de Empleados por Oficina
        System.out.println("**********************************************");
        System.out.println("             LISTA DE CLIENTE POR NOMBRE               ");
        System.out.println("**********************************************");
        System.out.println(" ID Cliente  |  Apellido Contacto | Nombre Contacto "); 
        System.out.println("------------------------------------------------------");

        String nombreABuscar = "Link";
        try { 
        clienteServicio.listarClientes(nombreABuscar);
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        }

        // Imprimir lista de Empleados por Oficina

        int codigoABuscar = 3;
        try { 
            empleadoServicio.listarEmpleadosPorOficina(codigoABuscar);
        } catch (Exception e) {
            System.out.println("Error al listar empleados por oficina: " + e.getMessage());
        }

    }
}
