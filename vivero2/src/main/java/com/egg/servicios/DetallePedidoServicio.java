package com.egg.servicios;

import com.egg.entidades.DetallePedido;
import com.egg.entidades.Pedido;
import com.egg.entidades.Producto;
//import com.egg.persistencia.ClienteDAO;
import com.egg.persistencia.DetallePedidoDAO;

public class DetallePedidoServicio {
    
    public final DetallePedidoDAO daoDetallePedido;

    public DetallePedidoServicio() {
        this.daoDetallePedido = new DetallePedidoDAO();
    }       

    public void guardarDetallePedido(int idPedido, int idProducto, double precio, int cantidad) {
        try {
            DetallePedido detallePedido = new DetallePedido();
    
            // Crear y asignar el pedido
            Pedido pedido = new Pedido();
            pedido.setIdPedido(idPedido); // Método en Pedido
            detallePedido.setPedido(pedido);
    
            // Crear y asignar el producto
            Producto producto = new Producto();
            producto.setIdProducto(idProducto); // Método en Producto
            detallePedido.setProducto(producto);
    
            // Asignar los demás valores
            detallePedido.setPrecioUnidad(precio);
            detallePedido.setCantidad(cantidad);
    
            daoDetallePedido.guardarDetallePedido(detallePedido);
    
        } catch (Exception e) {
            System.out.println("No se guardó el detalle del pedido de manera correcta");
        }
    }
}
