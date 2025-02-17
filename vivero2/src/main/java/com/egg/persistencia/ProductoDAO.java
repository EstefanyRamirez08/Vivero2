package com.egg.persistencia;

import com.egg.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarProducto(Producto producto) {
        try {
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            System.out.println("Producto guardado con éxito");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al guardar el producto: " + e.getMessage());
        }
    }
}
