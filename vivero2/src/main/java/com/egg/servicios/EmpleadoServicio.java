package com.egg.servicios;

import java.util.List;

//import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
//import com.egg.entidades.Empleado;
import com.egg.persistencia.EmpleadoDAO;    

public class EmpleadoServicio {
    private final EmpleadoDAO empleadoDAO;

    public EmpleadoServicio() {
        this.empleadoDAO = new EmpleadoDAO();
    }
    public void eliminarEmpleado(int idEmpleado) {
        empleadoDAO.eliminarEmpleado(idEmpleado);
    }

    public void listarEmpleadosOficinas() {
        try {
            List<Empleado> todosEmpleados = empleadoDAO.listarTodas(); // Se corrigió el nombre de la variable
            imprimirLista(todosEmpleados);
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de Empleados por Oficina: " + e.getMessage());
        }
    }

    private void imprimirLista(List<Empleado> listaRecibida) {
        for (Empleado empleado : listaRecibida) {
            // Acceder al ID de la oficina desde la relación "oficina"
            String idOficina = empleado.getOficina() != null ? String.valueOf(empleado.getOficina().getIdOficina()) : "Sin oficina";
    
            System.out.println(empleado.getIdEmpleado() + " - " + 
                               empleado.getNombre() + " - " + 
                               idOficina); // Aquí se imprime el ID de la oficina
        }
    
    }
}