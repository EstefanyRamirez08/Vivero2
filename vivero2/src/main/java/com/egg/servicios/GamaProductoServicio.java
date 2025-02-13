package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {

    private final GamaProductoDAO daoGamaProducto;

    public GamaProductoServicio() {
        this.daoGamaProducto = new GamaProductoDAO();
    }

    public void crearGamaProducto(String descripcionHtml, String descripcionTexto, String gama, String imagen) {
        try {
            GamaProducto gamaProducto = new GamaProducto();

            gamaProducto.setDescripcionHtml(descripcionHtml);
            gamaProducto.setDescripcionTexto(descripcionTexto);
            gamaProducto.setGama(gama);
            gamaProducto.setImagen(imagen);

            daoGamaProducto.guardaGamaProducto(gamaProducto);

            System.out.println("Gama Producto creado con éxito");
        } catch (Exception e) {
            System.out.println(e.toString() + " No se guardó la nueva gama de producto de manera correcta.");
        }
    }

    public GamaProducto buscarGamaProductoPorId(int idGama) {
        try {
            GamaProducto gama = daoGamaProducto.buscarGamaProducto(idGama);
            if (gama == null) {
                System.out.println("No se encontró ninguna gama con ID: " + idGama);
            }
            return gama;
        } catch (Exception e) {
            System.out.println("Error al buscar gama de producto: " + e.getMessage());
            return null;
        }
    } // 🔹 Se cerró correctamente el método

    public void actualizarGamaProducto(int idGama, String nuevaGama, String nuevaDescripcionHtml, String nuevaDescripcionTexto, String nuevaImagen) throws Exception {
        GamaProducto gamaProducto = daoGamaProducto.buscarGamaProducto(idGama); // 🔹 Se corrigió el nombre de la variable

        if (gamaProducto == null) {
            throw new Exception("No se encontró una gama de producto con el ID: " + idGama);
        }

        gamaProducto.setGama(nuevaGama);
        gamaProducto.setDescripcionHtml(nuevaDescripcionHtml);
        gamaProducto.setDescripcionTexto(nuevaDescripcionTexto);
        gamaProducto.setImagen(nuevaImagen);

        daoGamaProducto.guardaGamaProducto(gamaProducto); // 🔹 Se corrigió la llamada al método
    }
}