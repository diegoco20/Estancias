/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estancias;

import estancias.Entidades.casas;
import estancias.Entidades.familia;
import estancias.Persistencia.casasDao;
import estancias.Persistencia.familiaDao;
import estancias.Servicios.casaService;
import estancias.Servicios.familiaService;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        familiaDao famDao = new familiaDao();
        familiaService famSer = new familiaService();
        familia fam = null;
        
        casaService cs = new casaService();
        casasDao cd = new casasDao();
       
        cd.consultarCasasPrecioDesdePrepared(50);
        cd.consultarCasaCiudad("York");
        famDao.mostrarFamiliasBD();
        
        fam = famSer.generarFamiliaSinCasa(9);
        famSer.mostrarFamilia(fam);
        famDao.addFam(fam);
        
    }
    
}