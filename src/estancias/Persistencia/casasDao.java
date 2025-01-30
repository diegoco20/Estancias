package estancias.Persistencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import estancias.Entidades.casas;
import estancias.Persistencia.DAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public final class casasDao extends DAO{
    
    public void guardarCasa(casas casa) {

        try {
            if (casa == null) {
                throw new Exception("Debe indicar una casa");
            }

            // Verifica si el usuario ya existe por medio del código 
            String checkSql = "SELECT COUNT(*) FROM casas WHERE id_casa = " + casa.getId() + ";";
            consultarBase(checkSql);

            if (resultado.next()) {
                int count = resultado.getInt(1);
                
                if (count > 0) {
                    throw new Exception("La casa ya existe en la base de datos.");
                }                   
            }
            
            
            // Si el usuario no existe, insertar el nuevo usuario
            String sql = "INSERT INTO casas (id_casa, calle, numero, codigo_postal, ciudad, pais, desde, hasta, tiempo_min, tiempo_max, precio, tipo)"
                    + "VALUES ('" + casa.getId() + "' , '" + casa.getCalle() + "', '" + casa.getNumero() + "', '" + casa.getCodigo_postal() + "', '" + casa.getCiudad() 
                    + "', '" + casa.getPais() + "', '" + casa.getDesde() + "', '" + casa.getHasta() + "');"
                    + "', '" + casa.getTiempo_min() + "', '" + casa.getTiempo_max() + "', '" + casa.getPrecio() + "', '" + casa.getTipo() + "');";

            InstarModificarEliminar(sql);
            System.out.println("Casa con código: " + casa.getId() + " agregada");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void modificarCasa(casas casa){
        
        try {
            if (casa == null) {
                throw new Exception("Debe indicar una casa para modificar");
            }
            
            //Verificamos que la casa existe
            String checksql = "SELECT COUNT(*) FROM casas WHERE id_casa = " + casa.getId() + ";";
            consultarBase(checksql);
            
            if(resultado.next()) { 
                int count = resultado.getInt(1);
                if (count == 0 ){
                    throw new Exception("La casa con id " + casa.getId() + " no existe en la base de datos");
                }
            }
            
            //Construir la consulta SQL para actualizar la casa
            String sql = "UPDATE casas SET "
                + "calle = '" + casa.getCalle() + "', "
                + "numero = '" + casa.getNumero() + "', "
                + "codigo_postal = '" + casa.getCodigo_postal() + "', "
                + "ciudad = '" + casa.getCiudad() + "', "
                + "pais = '" + casa.getPais() + "', "
                + "desde = '" + casa.getDesde() + "', "
                + "hasta = '" + casa.getHasta() + "', "
                + "tiempo_min = '" + casa.getTiempo_min() + "', "
                + "tiempo_max = '" + casa.getTiempo_max() + "', "
                + "precio = '" + casa.getPrecio() + "', "
                + "tipo = '" + casa.getTipo() + "' "
                + "WHERE id_casa = " + casa.getId() + ";";
            
            InstarModificarEliminar(sql);
            System.out.println("Casa con código: " + casa.getId() + " actualizada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al modificar la casa: " + e.getMessage());
        }
    }
     
    public void eliminarCasa(casas casa){
        
        try {
            if (casa == null) {
                throw new Exception("Debe indicar una casa para eliminar");
            }
        
        //Verificamos que la casa existe
            String checksql = "SELECT COUNT(*) FROM casas WHERE id_casa = " + casa.getId() + ";";
            consultarBase(checksql);
            
            if(resultado.next()) { 
                int count = resultado.getInt(1);
                if (count == 0 ){
                    throw new Exception("La casa con id " + casa.getId() + " no existe en la base de datos");
                }
            }
            
            String sql = "DELETE FROM casas WHERE id_casa = '" + casa.getId() + ";";
            InstarModificarEliminar(sql);
            System.out.println("Casa con código: " + casa.getId() + " eliminada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar la casa: " + e.getMessage());
        }
    }
    
    public void consultarUsuarios() {
    String sql = "SELECT * FROM casas;";
    try {
        // Conectar a la base de datos
        conectar();
        
        // Crear un Statement y ejecutar la consulta
        sentencia = cx.createStatement();
        resultado = sentencia.executeQuery(sql);

        // Procesar los resultados
        while (resultado.next()) {
            // Aquí puedes acceder a los resultados, por ejemplo:
            int idCasa = resultado.getInt("id_casa");
            String calle = resultado.getString("calle");
            String numero = resultado.getString("numero");
            String codigoPostal = resultado.getString("codigo_postal");
            String ciudad = resultado.getString("ciudad");
            String pais = resultado.getString("pais");
            java.sql.Date desde = resultado.getDate("desde");
            java.sql.Date hasta = resultado.getDate("hasta");
            int tiempoMin = resultado.getInt("tiempo_min");
            int tiempoMax = resultado.getInt("tiempo_max");
            double precio = resultado.getDouble("precio");
            String tipo = resultado.getString("tipo");
        }
    } catch (SQLException ex) {
        System.out.println("Error en la consulta: " + ex.getMessage());
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Cerrar recursos
        desconectar();
    }
}
   
    
}
