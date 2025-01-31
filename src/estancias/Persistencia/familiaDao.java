/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Persistencia;

import estancias.Entidades.familia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author diego
 */
public final class familiaDao extends DAO {
    
    public void guardarFamilia(familia fam) {
        try {
            if (fam == null) {
                throw new Exception("Debe ingresar una familia");
            }

            // Verifica si la familia ya existe
            String checksql = "SELECT COUNT(*) FROM familias WHERE id_familia = ?";
            PreparedStatement checkStmt = cx.prepareStatement(checksql);
            //Se agina el valor sin concatenar
            checkStmt.setInt(1, fam.getId());
            ResultSet resultados = checkStmt.executeQuery();

            if (resultados.next() && resultados.getInt(1) > 0) {
                throw new Exception("La familia ya existe en la base de datos");
            }

            // Si no existe, insertar la familia
            String sql = "INSERT INTO familias (id_familia, nombre, edad_minima, edad_maxima, "
                    + "num_hijos, email, id_casa_familia) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = cx.prepareStatement(sql);
            stmt.setInt(1, fam.getId());
            stmt.setString(2, fam.getNombre());
            stmt.setInt(3, fam.getEdad_min());
            stmt.setInt(4, fam.getEdad_max());
            stmt.setInt(5, fam.getNum_hijos());
            stmt.setString(6, fam.getEmail());
            stmt.setInt(7, fam.getCasa().getId());

            stmt.executeUpdate();
            System.out.println("Familia con código: " + fam.getId() + " agregada");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void eliminarFamilia(familia fam) {
        
        try {
            //Verifica que familia no es null
            if (fam == null) {
                throw new Exception("Debe ingresar una familia");
            }
            
            //Verifica que familia existe
            String checksql = "SELECT COUNT(*) FROM familias WHERE id_familia = ?";
            PreparedStatement checkfam = cx.prepareStatement(checksql);
            
            //Asigna valor sin concatenar
            checkfam.setInt(1, fam.getId());
            ResultSet result = checkfam.executeQuery();
            
            if (result.next() && result.getInt(1) > 1) {
                throw new Exception("La familia ya existe en la base de datos");
            }
            
            //Elimina familia de base de datos
            String delsql = "DELETE FROM familias WHERE id_familia = ?";
            PreparedStatement delfam = cx.prepareStatement(delsql);
            //Asigna valor a query sin concatenar
            delfam.setInt(1, fam.getId());
            ResultSet resul = delfam.executeQuery();
            System.out.println("Familia " + fam.getId() + " agregada");
            
        } catch (Exception e ){
            System.out.println("Error agregando familia");
        }
    }
    
    public void modificarFamilia(familia fam){
        try {
            //Verificar familia no es null
            if (fam == null) {
                throw new Exception("Debe ingresar una familia");
            }
            
            String sql = "UPDATE familias SET "
                     + "nombre = " + fam.getNombre() + ";";
            InstarModificarEliminar(sql);
            
        } catch (Exception e){
            
        }
    }
    
    public void mostrarFamiliasBD(){
        String sql = "SELECT * FROM familias";
        Connection cx = null;
        PreparedStatement stmt = null;
        
        try {
            //Conectamos a la base datos
            cx = conectar();
            if (cx != null) {
                stmt = cx.prepareStatement(sql);
                resultado = stmt.executeQuery(sql);
            }
            
            System.out.println("Accediendo base de datos.");
            if(resultado.next()){
                System.out.println("Familia id: " + resultado.getInt(1));
                System.out.println("Familia nombre: " + resultado.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error al acceder a la base de datos");
        }
        
        desconectar();
    }
    
}
