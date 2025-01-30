/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Entidades;

/**
 *
 * @author diego
 */
public class familia {
    private int id;
    private casas casa;
    private String nombre;
    private int edad_min;
    private int edad_max;
    private int num_hjios;
    private String email;

    public familia() {
    }

    public familia(int id, casas casa, String nombre, int edad_min, int edad_max, int num_hjios, String email) {
        this.id = id;
        this.casa = casa;
        this.nombre = nombre;
        this.edad_min = edad_min;
        this.edad_max = edad_max;
        this.num_hjios = num_hjios;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public casas getCasa() {
        return casa;
    }

    public void setCasa(casas casa) {
        this.casa = casa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_min() {
        return edad_min;
    }

    public void setEdad_min(int edad_min) {
        this.edad_min = edad_min;
    }

    public int getEdad_max() {
        return edad_max;
    }

    public void setEdad_max(int edad_max) {
        this.edad_max = edad_max;
    }

    public int getNum_hjios() {
        return num_hjios;
    }

    public void setNum_hjios(int num_hjios) {
        this.num_hjios = num_hjios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
