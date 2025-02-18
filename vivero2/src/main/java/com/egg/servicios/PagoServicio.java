package com.egg.servicios;

import com.egg.entidades.Pago;

import java.util.List;

import com.egg.entidades.Cliente;
import com.egg.persistencia.PagoDAO;
import com.egg.persistencia.ClienteDAO;

public class PagoServicio {

    private final PagoDAO daoPago;
    private final ClienteDAO daoCliente;

    public PagoServicio() {
        this.daoPago = new PagoDAO();
        this.daoCliente = new ClienteDAO();
    }

    public void guardarPago(int id_pago, String forma_pago, String id_transaccion, double total, int id_cliente) {
        try {
            Pago pago = new Pago();
            pago.setIdPago(id_pago);
            pago.setFormaPago(forma_pago);
            pago.setIdTransaccion(id_transaccion);
            pago.setTotal(total);

            // Buscar el Cliente usando ClienteDAO
            Cliente cliente = daoCliente.obtenerClientePorId(id_cliente);
            if (cliente != null) {
                pago.setCliente(cliente);
            } else {
                throw new Exception("Cliente con ID " + id_cliente + " no encontrado");
            }

            daoPago.guardaPago(pago);
            System.out.println("Pago guardado con éxito");

        } catch (Exception e) {
            System.out.println(e.toString() + " No se guardó el pago de manera correcta");
        }
    }

    public void imprimirPagosPorCliente(String nombreContacto) {
        List<Pago> listaPagos = daoPago.listarPagosPorCliente(nombreContacto);
        for (Pago pago : listaPagos) {
            System.out.println(pago.getIdPago() + " | " +
                               pago.getFechaPago() + " | " +
                               pago.getFormaPago() + " | " +
                               pago.getIdTransaccion() + " | " +
                               pago.getTotal());
        }
    }
}

