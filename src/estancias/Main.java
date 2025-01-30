/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estancias;

import estancias.Servicios.casaService;
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
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[4];
        
        casaService cs = new casaService();
        
        cs.codificador();
        
        
        
        
    }
    
}