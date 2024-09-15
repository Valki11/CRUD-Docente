/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.HeadlessException;
import java.util.Date;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Persona {
    
    Conexion cn;
    // Atributos privados
    private String nit;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;

    // Constructor
    public Persona(String nit, String nombres, String apellidos, String direccion, String telefono, Date fechaNacimiento) {
        this.nit = nit;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona() {
    }

    // Getters
    public String getNit() {
        return nit;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setters
    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void agregar() throws SQLException{
    try{
        PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         String query;
            query = "insert into persona(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) "+
                 "values(?,?,?,?,?,?);";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setString(1, getNit());
         parametro.setString(2, getNombres());
         parametro.setString(3, getApellidos());
         parametro.setString(4, getDireccion());
         parametro.setString(5, getTelefono());
         parametro.setDate(6, (java.sql.Date) getFechaNacimiento());
         
         int executar= parametro.executeUpdate();
         cn.cerrar_conexion();
        JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Ingresado",
             "Mensaje",JOptionPane.INFORMATION_MESSAGE);
         
    }catch(HeadlessException ex){
         System.out.println("Error"+ex.getMessage());
     }
    }
    
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla= new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query;
            query = "Select nit,nombres,apellidos,direccion,telefono,fecha_nacimiento from persona ";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
            String encabezado[] = {"Nit","Nombres","Apellidos","Direccion","Telefono","Nacimiento"};
            tabla.setColumnIdentifiers(encabezado);
            
            String datos[]=new String[6];
      
            while(consulta.next()){
                datos[0] = consulta.getString("Nit");
                datos[1] = consulta.getString("nombres");
                datos[2] = consulta.getString("apellidos");
                datos[3] = consulta.getString("direccion");
                datos[4] = consulta.getString("telefono");
                datos[5] = consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
                }
        }catch(SQLException ex){
            cn.cerrar_conexion();
            System.out.println("Error: " + ex.getMessage() );
        }
        return tabla;
  }
        
    public void actualizar(){
        try{
            PreparedStatement parametro;
             cn = new Conexion();
             cn.abrir_conexion();
            String query;
            query = "update persona nombres= ?,apellidos= ?,direccion= ?,telefono= ?,fecha_nacimiento= ?"+
                    "where nit = ?";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);  
            parametro.setString(1, getNombres());
            parametro.setString(2, getApellidos());
            parametro.setString(3, getDireccion());
            parametro.setString(4, getTelefono());
            parametro.setDate(5, (java.sql.Date) getFechaNacimiento());
            parametro.setString(6, getNit());
            int executar= parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Actualizado",
            "Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
     }
    }
      public void eliminar(){
          try{
              PreparedStatement parametro;
            cn = new Conexion();
            cn.abrir_conexion();
            String query;
            query = "delete from persona where nit = ?";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNit()); 
            int executar= parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Eliminado",
            "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            
          }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
     }   
      }     
    }