package com.egg.servicios;

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

}
