package com.egg.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gama_producto")
public class GamaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gama")
    private int idgama;

    @Column(name = "descripcion_html", length = 500)
    private String descripcionHtml;

    @Column(name = "descripcion_texto", length = 500)
    private String descripcionTexto;

    @Column(name = "gama", length = 255)
    private String gama;

    @Column(name = "imagen", length = 50)
    private String imagen;

    @OneToMany(mappedBy = "gamaProducto", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Producto> productos;  // Relación con productos

    public GamaProducto() {
    }

    public int getIdgama() {
        return idgama;
    }

    public void setIdgama(int idgama) {
        this.idgama = idgama;
    }

    public String getDescripcionHtml() {
        return descripcionHtml;
    }

    public void setDescripcionHtml(String descripcionHtml) {
        this.descripcionHtml = descripcionHtml;
    }

    public String getDescripcionTexto() {
        return descripcionTexto;
    }

    public void setDescripcionTexto(String descripcionTexto) {
        this.descripcionTexto = descripcionTexto;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "GamaProducto{" +
                "gama='" + gama + '\'' +
                ", descripcionHtml='" + descripcionHtml + '\'' +
                ", descripcionTexto='" + descripcionTexto + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

}