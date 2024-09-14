/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

public class Docente {
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
}
