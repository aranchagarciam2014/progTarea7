/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog07_tarea;

/**
 *
 * @author AranchaGarcía
 * 
 * Las cuentas corrientes personales, 
 * que tienen una comisión de mantenimiento (una cantidad fija anual.
 * 
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

//atributo de la clase CuentaCorrientePersonal    
    private  double comisionMantenimiento;
 
// constructore de la clase CuentaCorrientePersonal    
    public CuentaCorrientePersonal (Persona titular, double saldo, String numberCuenta,String entidadesAutorizadas, double comisionMantenimiento){
        super (titular, saldo, numberCuenta);
        this.comisionMantenimiento = comisionMantenimiento;
    }
// getters y setters de la clase CuentaCorrientePersonal    
    public double getComisionMantenimiento() {
	return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
//método que devuelve los datos de la comisión de mantenimiento
    public String devolverInfoString() {
        //Creamos una variable para que nos devuelva por consola los datos agrupados
	String datosCuentaPersonal;
        datosCuentaPersonal = "Los datos de la cuenta bancaria son: \n"
                                +"Nombre "+titular.getNombreTitular()+"\n"
                                +"Apellidos "+titular.getApellidosTitular()+"\n"
                                +"DNI "+titular.getDni()+"\n"
                                +"Saldo "+saldo+"\n"
                                +"IBAN "+numberCuenta+"\n"
                                +"Comisión de mantenimiento "+comisionMantenimiento+"\n";
        return datosCuentaPersonal;
	}
    
}
