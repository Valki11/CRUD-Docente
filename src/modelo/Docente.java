/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Docente {
    Conexion cn;
    private String codigoDocente;
    private double salario;
    private Date fechaIngresoLaborar;
    private Date fechaIngresoRegistro;

    // Constructor
    public Docente(String codigoDocente, double salario, Date fechaIngresoLaborar, Date fechaIngresoRegistro) {
        this.codigoDocente = codigoDocente;
        this.salario = salario;
        this.fechaIngresoLaborar = fechaIngresoLaborar;
        this.fechaIngresoRegistro = fechaIngresoRegistro;
    }   

    public Docente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Docente(String text, String text0, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters
    public String getCodigoDocente() {
        return codigoDocente;
    }

    public double getSalario() {
        return salario;
    }

    public Date getFechaIngresoLaborar() {
        return fechaIngresoLaborar;
    }

    public Date getFechaIngresoRegistro() {
        return fechaIngresoRegistro;
    }

    // Setters
    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFechaIngresoLaborar(Date fechaIngresoLaborar) {
        this.fechaIngresoLaborar = fechaIngresoLaborar;
    }

    public void setFechaIngresoRegistro(Date fechaIngresoRegistro) {
        this.fechaIngresoRegistro = fechaIngresoRegistro;
    }
    public void agregar() throws SQLException{
    try{
        PreparedStatement parametro;
         cn = new Conexion();
         cn.abrir_conexion();
         Date Fecha= new Date();
         String query;
            query = "insert into docente(salario,fecha_ingreso_laborar,fecha_ingreso_registro) "+
                 "values(?,?,?);";
         parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
         parametro.setDouble(1, getSalario());
         parametro.setDate(2, (java.sql.Date) getFechaIngresoLaborar());
         parametro.setDate(3, (java.sql.Date) Fecha);
         
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
            query = "Select codigo_docente,salario,fecha_ingreso_laborar from docente";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      
            String encabezado[] = {"codigo docente","Salario","Fecha imgreso laborar"};
            tabla.setColumnIdentifiers(encabezado);
            
            String datos[]=new String[3];
      
            while(consulta.next()){
                datos[0] = consulta.getString("codigo");
                datos[1] = consulta.getString("salario");
                datos[2] = consulta.getString("Fecha imgreso laborar");
                
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
            query = "update docente salario=?,fecha_ingreso_laborar= ?"+
                    "where codigo_docente = ?";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);  
            parametro.setDouble(1, getSalario());
            parametro.setDate(2, (java.sql.Date) getFechaIngresoLaborar());
            parametro.setString(3, getCodigoDocente());
           
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
            query = "delete from docente where codigo_docente = ?";
            parametro  = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getCodigoDocente()); 
            int executar= parametro.executeUpdate();
            cn.cerrar_conexion();
            JOptionPane.showMessageDialog(null,Integer.toString(executar) + " Registro Eliminado",
            "Mensaje",JOptionPane.INFORMATION_MESSAGE);
            
          }catch(HeadlessException | SQLException ex){
         System.out.println("Error"+ex.getMessage());
     }   
      }     
    }
