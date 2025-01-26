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
public class estancias {
    private int id_estancia;
    private clientes cliente;
    private casas casa;
    private LocalDate hasta;
    private LocalDate desde;
    
    
    public estancias(){
    }

    public estancias(int id_estancia, clientes cliente, casas casa, LocalDate hasta, LocalDate desde) {
        this.id_estancia = id_estancia;
        this.cliente = cliente;
        this.casa = casa;
        this.hasta = hasta;
        this.desde = desde;
    }

    
    public int getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public casas getCasa() {
        return casa;
    }

    public void setCasa(casas casa) {
        this.casa = casa;
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
    
    
    
}
