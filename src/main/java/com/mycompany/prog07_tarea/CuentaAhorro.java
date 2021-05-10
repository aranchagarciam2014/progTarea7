/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog07_tarea;

/**
 *
 * @author AranchaGarcía
 */
public class CuentaAhorro extends CuentaBancaria {

//Declaro el atributo de la clase    
    private double tipoInteres;
    
//Constructor de la clase CuentaAhorro    
    public CuentaAhorro (Persona titular, double saldo, String numberCuenta, double tipoInteres) {
    super (titular, saldo, numberCuenta);
        this.tipoInteres = tipoInteres;
    }
        
// getters y setters de la clase      
    public double getTipoInteres() {
	return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
            this.tipoInteres = tipoInteres;
    }
    
    //Método que devuelve el tipo de interés
    
    public String devolverInfoString (){
        //Creamos una variable para que nos devuelva por consola los datos agrupados
        String datosCuentaAhorro;
        datosCuentaAhorro = "Los datos de la cuenta bancaria son: \n"
                                +"Nombre "+titular.getNombreTitular()+"\n"
                                +"Apellidos "+titular.getApellidosTitular()+"\n"
                                +"DNI "+titular.getDni()+"\n"
                                +"Saldo "+saldo+"\n"
                                +"IBAN "+numberCuenta+"\n"
                                +"Tipo de interés "+tipoInteres+"\n";
        return datosCuentaAhorro;
    }
}

