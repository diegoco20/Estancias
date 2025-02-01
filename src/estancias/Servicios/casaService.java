/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Servicios;

import estancias.Entidades.casas;
import estancias.Persistencia.casasDao;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author diego
 */

public class casaService {

    private casas casa;
    private casasDao casaDao; 

    public casaService() {
        this.casa = new casas();
        this.casaDao = new casasDao();
                
    }
    public casaService(casas casa, casasDao casadao){
        this.casa = casa;
        this.casaDao = casadao;
    }
    
    public casas generarCasa(int id){
        Random random = new Random();
        
        String[] calles = {"Avenida Reforma", "Calle 7", "Boulevard Principal", "Avenida Libertad", "Callejón del Sol"};
        String[] ciudades = {"Ciudad de México", "Madrid", "Buenos Aires", "Bogotá", "Lima"};
        String[] paises = {"México", "España", "Argentina", "Colombia", "Perú"};
        String[] tipos = {"Apartamento", "Casa", "Dúplex", "Villa", "Penthouse"};
        
        String calle = calles[random.nextInt(calles.length)];
        int numero = random.nextInt(999) + 1; // Número entre 1 y 999
        String codigo_postal = String.format("%05d", random.nextInt(99999)); // Código postal de 5 dígitos
        String ciudad = ciudades[random.nextInt(ciudades.length)];
        String pais = paises[random.nextInt(paises.length)];
        String tipo = tipos[random.nextInt(tipos.length)];

        // Generar fechas aleatorias
        LocalDate desde = LocalDate.now().plusDays(random.nextInt(30)); // Desde hoy + 0 a 30 días
        LocalDate hasta = desde.plusDays(random.nextInt(60) + 30); // Hasta al menos 30 días después

        int tiempo_min = random.nextInt(7) + 3;  // Mínimo entre 3 y 9 días
        int tiempo_max = tiempo_min + random.nextInt(30); // Máximo entre min y min+30 días
        int precio = (random.nextInt(50) + 10) * 100; // Precio entre 1000 y 6000

        return new casas(id, calle, numero, codigo_postal, ciudad, pais, desde, hasta, tiempo_min, tiempo_max, precio, tipo);
    }
    
    public void insertarCasa(casas casa){
        casaDao.guardarCasa(casa);
    }
    
    
}
