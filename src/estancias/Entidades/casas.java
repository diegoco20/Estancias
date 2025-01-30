/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Entidades;

import java.time.LocalDate;

/**
 *
 * @author diego
 */
public class casas {
    private int id;
    private String calle;
    private int numero;
    private String codigo_postal;
    private String ciudad;
    private String pais;
    private LocalDate hasta;
    private LocalDate desde;
    private int tiempo_min;
    private int tiempo_max;
    private int precio;
    private String tipo;

    public casas() {
    }

    public casas(int id, String calle, int numero, String codigo_postal, String ciudad, String pais, LocalDate hasta, LocalDate desde, int tiempo_min, int tiempo_max, int precio, String tipo) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.hasta = hasta;
        this.desde = desde;
        this.tiempo_min = tiempo_min;
        this.tiempo_max = tiempo_max;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public int getTiempo_min() {
        return tiempo_min;
    }

    public void setTiempo_min(int tiempo_min) {
        this.tiempo_min = tiempo_min;
    }

    public int getTiempo_max() {
        return tiempo_max;
    }

    public void setTiempo_max(int tiempo_max) {
        this.tiempo_max = tiempo_max;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
