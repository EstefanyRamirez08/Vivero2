package com.egg.persistencia;

import java.util.List;
import com.egg.entidades.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
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
    // quitamos el + de la línea 49 en el set parameter para que funcione correctamente
    public List<Empleado> listarEmpleadosPorOficina(int codigoABuscar) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("Ejecutando consulta para empleados en la oficina con código: " + codigoABuscar);
            
            List<Empleado> empleados = em.createQuery(
                    "SELECT e FROM Empleado e WHERE e.oficina.idOficina = :codigo", Empleado.class)
                    .setParameter("codigo", codigoABuscar)
                    .getResultList();
            
            System.out.println("Número de empleados encontrados: " + empleados.size());
            return empleados;
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            throw e;
        } finally {
            em.close();
        }
    }

    
    public List<Empleado> listarEmpleadosExcluyendo(int idEmpleado) throws Exception {
            return em.createQuery(
                "SELECT e FROM Empleado e WHERE e.idEmpleado <> :idEmpleado", Empleado.class)
                .setParameter("idEmpleado", idEmpleado)
                .getResultList();
        
        
        }
    }

