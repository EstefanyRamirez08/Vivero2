package com.egg.persistencia;

import java.util.List;

//import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmpleadoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaEmpleado(Empleado empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    public void eliminarEmpleado(int idEmpleado) {
        em.getTransaction().begin();
        Empleado empleado = em.find(Empleado.class, idEmpleado);
        if (empleado != null) {
            em.remove(empleado);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("No se encontró un empleado con ID: " + idEmpleado);
        }
        em.getTransaction().commit();
    }

    public List<Empleado> listarTodas() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Empleado e", Empleado.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}
