/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Servicios;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class casaService {
    public void codificador(){
        Scanner sc = new Scanner(System.in);
        String palabra = new String();
                 
        System.out.println("Ingrese una frase para codificar: ");
        palabra = sc.nextLine();
        StringBuilder resultado = new StringBuilder(palabra);
        for (int i = 0; i < palabra.length(); i++){
            char vocal = Character.toLowerCase(palabra.charAt(i));
    
            switch (vocal) {
                case 'a':
                    resultado.setCharAt(i, '@');
                    break;
                case 'e':
                    resultado.setCharAt(i, '3');
                    break;
                case 'i':
                    resultado.setCharAt(i, '1');
                    break;
                case 'o':
                    resultado.setCharAt(i, '0');
                    break;
                case 'u':
                    resultado.setCharAt(i, '7');
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(resultado.toString());
    }
}
