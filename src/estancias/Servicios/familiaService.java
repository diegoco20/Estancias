/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Servicios;

import estancias.Entidades.casas;
import estancias.Entidades.familia;
import estancias.Persistencia.familiaDao;
import java.util.Random;

/**
 *
 * @author diego
 */
public class familiaService {
    private familia fam;
    private familiaDao famDao;
    private Random random = new Random();
    
    public familiaService(){
        this.fam = new familia();
        this.famDao = new familiaDao();
    }
    
    public familiaService(familia fam, familiaDao famDao){
        this.fam = fam;
        this.famDao = famDao;
    }
    
    public familia generarFamiliaSinCasa(int id){
        //Lista de datos aleatorios
        String[] nombres = {"García", "Pérez", "Rodríguez", "Fernández", "López"};
        String nombre = nombres[random.nextInt(nombres.length)];
        int edadMin = random.nextInt(15) + 1;
        int edadMax = edadMin + random.nextInt(15) + 1;
        int numHijos = random.nextInt(5) + 1;
        String email = nombre.toLowerCase() + random.nextInt(100) + "@familia.com";
        int idCasaFamilia = random.nextInt(50) + 1;
        
        return new familia(id, nombre, edadMin, edadMax, numHijos, email);
    }
    
    public void mostrarFamilia(familia fam){
        System.out.println(fam);
    }
}
