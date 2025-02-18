package com.egg.persistencia;

import java.util.List;

//import com.egg.entidades.Empleado;
import com.egg.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private EntityManager em; 

    public ProductoDAO() {
        this.em = emf.createEntityManager(); // Se inicializa una vez
    }

    public void guardarProducto(Producto producto) {
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            System.out.println("Producto guardado con éxito");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error al guardar el producto: " + e.getMessage());
        }
    }

    public List<Producto> listarTodos() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class)
                 .getResultList();
    }

    public List<Producto> listarProductosExcluyendo(int idGama) throws Exception {
    return em.createQuery(
            "SELECT p FROM Producto p " +
            "JOIN p.gamaProducto g " +
            "WHERE p.idGama <> :idGama", Producto.class)
            .setParameter("idGama", idGama)
            .getResultList();
}

    public void cerrar() {
        if (em.isOpen()) {
            em.close();
        }
        emf.close();
    }
}
