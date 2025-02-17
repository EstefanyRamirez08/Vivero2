package com.egg.persistencia;

import com.egg.entidades.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PedidoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarPedido(Pedido pedido) {
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            System.out.println("Pedido guardado con éxito");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al guardar el pedido: " + e.getMessage());
        }
    }
}