package estancias.Persistencia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import estancias.Entidades.casas;
import estancias.Persistencia.DAO;
import java.sql.PreparedStatement;
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
            String sql = "INSERT INTO casas (id_casa, calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda)"
                    + "VALUES ('" + casa.getId() + "' , '" + casa.getCalle() + "', '" + casa.getNumero() + "', '" + casa.getCodigo_postal() + "', '" + casa.getCiudad() 
                    + "', '" + casa.getPais() + "', '" + casa.getDesde() + "', '" + casa.getHasta()
                    + "', '" + casa.getTiempo_min() + "', '" + casa.getTiempo_max() + "', '" + casa.getPrecio() + "', '" + casa.getTipo() + "');";

            InstarModificarEliminar(sql);
            System.out.println("Casa con código: " + casa.getId() + " agregada");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void modificarCasa(casas casa, int id){
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
                + "fecha_desde = '" + casa.getDesde() + "', "
                + "fecha_hasta = '" + casa.getHasta() + "', "
                + "tiempo_minimo = '" + casa.getTiempo_min() + "', "
                + "tiempo_maximo = '" + casa.getTiempo_max() + "', "
                + "precio_habitacion = '" + casa.getPrecio() + "', "
                + "tipo_vivienda = '" + casa.getTipo() + "' "
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
            
            String sql = "DELETE FROM casas WHERE id_casa = " + casa.getId() + ";";
            InstarModificarEliminar(sql);
            System.out.println("Casa con código: " + casa.getId() + " eliminada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar la casa: " + e.getMessage());
        }
    }
    
    public void consultarCasas() {
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
            java.sql.Date desde = resultado.getDate("fecha_desde");
            java.sql.Date hasta = resultado.getDate("fecha_hasta");
            int tiempoMin = resultado.getInt("tiempo_minimo");
            int tiempoMax = resultado.getInt("tiempo_maximo");
            double precio = resultado.getDouble("precio_habitacion");
            String tipo = resultado.getString("tipo_vivienda");
            
            System.out.println("Casa " + idCasa + " precio: " + precio);
        }
        
        
        
        
    } catch (SQLException ex) {
        System.out.println("Error en la consulta: " + ex.getMessage());
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Cerrar recursos
        desconectar();
    }
}
    
    public void consultarCasasPrecioDesde(int precio){
        String sql = "SELECT id_casa, precio_habitacion FROM casas WHERE precio_habitacion > ? ;";
        
        //Verificación de precio
        if (precio < 0) {
               System.out.println("Debe ingresar un precio postivo");
               return;
            }
        
        try {
            // Conectamos a la base de datos
            conectar();
            //Creamos una sentencia y un result set 
            sentencia = cx.createStatement();
            resultado = sentencia.executeQuery(sql);
            
            //Procesamos los resultados 
            while (resultado.next()) {
                System.out.println("Casa:" + resultado.getInt("id_casa")
                        + "    precio = " + resultado.getDouble(2));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //Cerramos los recursos
        desconectar();
    }
    
    public void consultarCasasPrecioDesdePrepared(int precio){
        //Consulta parametrizada
        
        String sql = "SELECT id_casa, precio_habitacion FROM casas WHERE precio_habitacion > ? ;";
        
        //Verificación de precio
        if (precio < 0) {
               System.out.println("Debe ingresar un precio postivo");
               return;
            }
        
        try {
            // Conectamos a la base de datos
            conectar();
            //Creamos una sentencia y un result set 
            PreparedStatement stmt = cx.prepareStatement(sql);
            //Asignamos el parámetro
            stmt.setInt(1, precio);
            
            // Ejecutamos la consulta
            resultado = stmt.executeQuery();
            
            //Procesamos los resultados 
            while (resultado.next()) {
                System.out.println("Casa:" + resultado.getInt("id_casa")
                        + "    precio = " + resultado.getDouble(2));
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
        //Cerramos los recursos
        desconectar();
    }
    
    public void consultarCasaCiudad(String ciudad){
        String sql = "SELECT id_casa, ciudad FROM casas WHERE ciudad = ?;";
        
        try{
            //Crear una conexión
            conectar();
            //Creamos una statment
            PreparedStatement stmt = cx.prepareStatement(sql);
            //Asignamos parámetros
            stmt.setString(1, ciudad);
            //Ejecutamos statement
            resultado = stmt.executeQuery();
            
            //Mostramos los resultados
            while(resultado.next()){
                System.out.println("Casa id = " + resultado.getInt(1) + " ciudad = " + resultado.getString(2));
            }
            
        } catch (Exception e){
            System.out.println("Error en la consulta: " + e.getMessage());
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }           
    }
}
