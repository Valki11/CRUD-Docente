/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author keila
 */
public class Conexion {
    public Connection conexionBD;
    public final String bd= "docentes_db";
    public final String urlConexion=String.format("jsbc:mysql://localhost:3306/bd/%s?serverTimezone=UTC",bd);
    public final String usuario= "root";
    public final String contra = "root";
    public final String jdbc="com.mysql.cj.jdbc.Driver";
    
   public void abrir_conexion() {
    try {
        Class.forName(jdbc);
        conexionBD = DriverManager.getConnection(urlConexion, usuario, contra);
        if (conexionBD != null) {
            // Connection successful (optional: display a success message)
        } else {
            System.out.println("Error: Connection failed!");
            // Handle error (e.g., display message to user)
        }
    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    
    }
}