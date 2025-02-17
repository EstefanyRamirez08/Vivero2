
package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente obtenerClientePorId(int idCliente) {
        return em.find(Cliente.class, idCliente);
    }

    public List<Cliente> listarTodas() throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }
}