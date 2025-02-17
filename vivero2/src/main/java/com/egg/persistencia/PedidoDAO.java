package com.egg.persistencia;


import com.egg.entidades.Pedido;

//import com.egg.entidades.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PedidoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");

    public void guardarPedido(Pedido pedido) {  
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();       
    }
}