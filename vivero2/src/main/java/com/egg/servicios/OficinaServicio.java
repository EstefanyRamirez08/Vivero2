package com.egg.servicios;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;
import java.util.List; 

public class OficinaServicio {
    private final OficinaDAO daoOficina;

    public OficinaServicio() {
        this.daoOficina = new OficinaDAO();
    }

    public void crearOficina(String codigoOficina, String ciudad, String pais,
            String region, String telefono, String codigoPostal) {
        try {
            Oficina oficinaNueva = new Oficina();

            oficinaNueva.setCodigoOficina(codigoOficina);
            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setPais(pais);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);
            oficinaNueva.setCodigoPostal(codigoPostal);

            daoOficina.guardaOficina(oficinaNueva);
        } catch (Exception e) {
            System.out.println(e.toString() + " No se guardó la nueva oficina de manera correcta");
        }
    }

    public void listarOficinas() {
        try {
            List<Oficina> todasOficinas = daoOficina.listarTodas();
            imprimirLista(todasOficinas);
        } catch (Exception e) {
            // Manejo de la excepción
            System.out.println("Error al listar oficinas: " + e.getMessage());
        }
    }
    
        public void imprimirLista(List<Oficina> listaRecibida) throws Exception {
            for (Oficina unitariaOficina : listaRecibida) {
                System.out.println(unitariaOficina.getCodigoOficina() + " - " + unitariaOficina.getCiudad() + " - " + unitariaOficina.getPais());
            }
        }
    }