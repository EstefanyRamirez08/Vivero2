package com.egg.persistencia;

import com.egg.entidades.GamaProducto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GamaProductoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private EntityManager em = emf.createEntityManager();

    public void guardaGamaProducto(GamaProducto gamaProducto) throws Exception {
        em.getTransaction().begin();
        em.persist(gamaProducto);
        em.getTransaction().commit();
    }

     // Buscar una gama de producto por ID
     public GamaProducto buscarGamaProducto(int idGama) {
        return em.find(GamaProducto.class, idGama);
    }

    
    public void actualizarGamaProducto(GamaProducto gamaProducto) throws Exception {
        em.getTransaction().begin();
        em.merge(gamaProducto); // Sincroniza los cambios con la BD
        em.getTransaction().commit();
    }

    
}



