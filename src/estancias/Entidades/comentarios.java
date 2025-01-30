/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Entidades;

/**
 *
 * @author diego
 */
public class comentarios {
    private int id;
    private casas casa;
    private String comentario;

    public comentarios() {
    }

    public comentarios(int id, casas casa, String comentario) {
        this.id = id;
        this.casa = casa;
        this.comentario = comentario;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
