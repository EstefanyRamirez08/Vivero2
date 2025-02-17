package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Pedido;
import com.egg.persistencia.PedidoDAO;

public class PedidoServicio {
    
    private final PedidoDAO daoPedido;

    public PedidoServicio() {
        this.daoPedido = new PedidoDAO();
    }

    public void guardarPedido(int idPedido, int codigoPedido, String comentarios, String estado, Cliente cliente) {
        try {
            Pedido pedido = new Pedido();
            pedido.setIdPedido(idPedido);
            pedido.setCodigoPedido(codigoPedido);
            pedido.setComentarios(comentarios);
            pedido.setEstado(estado);
            pedido.setCliente(cliente);

            daoPedido.guardarPedido(pedido);
            System.out.println("Pedido guardado correctamente");

        } catch (Exception e) {
            System.out.println("No se guardó el pedido de manera correcta: " + e.getMessage());
        }
    }
}
