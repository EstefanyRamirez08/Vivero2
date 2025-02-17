package com.egg.persistencia;

import com.egg.entidades.Pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PagoDAO {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaPago(Pago pago) throws Exception {
        em.getTransaction().begin();
        em.merge(pago);
        em.getTransaction().commit();
    }
}
