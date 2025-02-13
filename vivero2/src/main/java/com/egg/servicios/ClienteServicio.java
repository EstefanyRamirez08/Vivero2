package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {

    private final ClienteDAO daoCliente;

    public ClienteServicio() {
        this.daoCliente = new ClienteDAO();
    }

    public void crearCliente(String apellidoContacto, String ciudad,int codigoCliente,String codigoPostal,String fax, int idEmpleado, double limiteCredito,
    String nombreCliente,String nombreContacto, String pais,String regio, String telefono) {


        try {

            Cliente cliente = new Cliente();

            cliente.setApellidoContacto(apellidoContacto);
            cliente.setCiudad(ciudad);
            cliente.setCodigoCliente(codigoCliente);
            cliente.setCodigoPostal(codigoPostal);
            cliente.setFax(fax);
            cliente.setIdEmpleado(idEmpleado);
            cliente.setLimiteCredito(limiteCredito);
            cliente.setNombreCliente(nombreCliente);
            cliente.setNombreContacto(nombreContacto);
            cliente.setPais(pais);
            cliente.setRegion(regio);
            cliente.setTelefono(telefono);

            daoCliente.guardaCliente(cliente);

            System.out.println("Cliente creado con éxito");

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el  nuevo cliente de manera correcta");
        }

   

    }
}


    

