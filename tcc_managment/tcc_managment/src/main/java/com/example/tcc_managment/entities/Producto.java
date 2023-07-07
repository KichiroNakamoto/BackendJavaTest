package com.example.tcc_managment.entities;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "volumen")
    private Double volumen;

    @Column(name = "lugarAlmacenaje", length = 50)
    private String lugarAlmacenaje;

    @Column(name = "fechaEntrada", length = 50)
    private Date fechaEntrada;

    @Column(name = "codigoBarras", length = 50)
    private String codigoBarras;

    public Producto(Integer id, String nombre, Double volumen, String lugarAlmacenaje, Date fechaEntrada, String codigoBarras) {
        this.id = id;
        this.nombre = nombre;
        this.volumen = volumen;
        this.lugarAlmacenaje = lugarAlmacenaje;
        this.fechaEntrada = fechaEntrada;
        this.codigoBarras = codigoBarras;
    }

    public Producto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarAlmacenaje() {
        return lugarAlmacenaje;
    }

    public void setLugarAlmacenaje(String lugarAlmacenaje) {
        this.lugarAlmacenaje = lugarAlmacenaje;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

}