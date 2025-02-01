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
    private int num_hijos;
    private String email;

    public familia() {
    }

    public familia(int id, String nombre, int edad_min, int edad_max, int num_hijos, String email, casas casa) {
        this.id = id;
        this.casa = casa;
        this.nombre = nombre;
        this.edad_min = edad_min;
        this.edad_max = edad_max;
        this.num_hijos = num_hijos;
        this.email = email;
    }
    
    public familia(int id, String nombre, int edadMin, int edadMax, int numHijos, String email) {
        // Llama al constructor principal con casa = null
        this(id, nombre, edadMin, edadMax, numHijos, email, null);
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

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hjios) {
        this.num_hijos = num_hjios;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "familia{" + "id=" + id + ", casa=" + casa + ", nombre=" + nombre + ", edad_min=" + edad_min + ", edad_max=" + edad_max + ", num_hijos=" + num_hijos + ", email=" + email + '}';
    }
    
    
}
