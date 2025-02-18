package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Empleado;
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

    public List<Pago> listarPagosPorCliente(String nombreContacto) {
        return em.createQuery(
            "SELECT p FROM Pago p JOIN p.cliente c WHERE c.nombreContacto = :nombreContacto",
            Pago.class)
            .setParameter("nombreContacto", nombreContacto)
            .getResultList();
    }
}



