/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Persistencia;

import estancias.Entidades.familia;

/**
 *
 * @author diego
 */
public final class familiaDao extends DAO {
    
    public void guardarFamilia(familia fam){
        try {
            
            //Verifica que la familia ingresada no es nula
            if (fam == null) {
                throw new Exception("Debe ingresar una familia");
            }
            
            //Verifica si la familia ya existe en la base de datos
            String checksql = ("SELECT (*) FROM familias WHERE id_familia = " + fam.getId() + ";");
            consultarBase(checksql);
            
            if (resultado.next()){
                int count = resultado.getInt(1);
                if (count > 0) {
                    throw new Exception("La casa ya existe en la base de datos");
                }
            }
        } catch (Exception e) {
            
        }
    }
}
