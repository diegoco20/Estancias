/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.Persistencia;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */

public class DAO {
    private final String bd = "estancias_exterior";
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String password = "root";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    protected Statement sentencia = null;
    protected Connection cx = null;
    protected ResultSet resultado = null;

    public DAO() {}
    
    public Connection conectar() {
        try {
            // Explicit driver loading is optional for modern JDBC drivers
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Connected to database: " + bd);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database driver not found.");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database: " + bd);
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }

    public void desconectar() {
    try {
        // Cierra el ResultSet si no es nulo
        if (resultado != null) {
            resultado.close();
            System.out.println("ResultSet closed.");
        }
        
        // Cierra el Statement si no es nulo
        if (sentencia != null) {
            sentencia.close();
            System.out.println("Statement closed.");
        }
        
        // Cierra la conexión si no es nula
        if (cx != null) {
            cx.close();
            System.out.println("Database connection closed.");
        } else {
            System.out.println("No active connection to close.");
        }
    } catch (SQLException ex) {
        // Maneja excepciones en el cierre de recursos
        System.out.println("Error while closing resources.");
        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    protected void InstarModificarEliminar(String sql){
        
        //Conectamos a la base de datos
        try {
            cx = conectar();
            if (cx != null) {
                sentencia = cx.createStatement();
                sentencia.executeUpdate(sql);
                System.out.println("SQL statement executed successfully.");
            }
        } catch (SQLException ex) {
            System.out.println("Error executing SQL statement: " + ex.getMessage());
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar recursos
            desconectar();
        }
        }
    
    protected void consultarBase(String sql) throws Exception {
        try {
           conectar();
           sentencia = cx.createStatement();
           resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex){
            throw ex;
        } /*finally {
            desconectar();
        }*/
    }

    public static void main(String[] args) {
    }
 
    private Object[] obtenerValores(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields(); // Obtiene todos los atributos del objeto
        Object[] values = new Object[fields.length];

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true); // Permitir acceso a atributos privados
                values[i] = fields[i].get(obj); // Extraer valor
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return values;
}
    
}
