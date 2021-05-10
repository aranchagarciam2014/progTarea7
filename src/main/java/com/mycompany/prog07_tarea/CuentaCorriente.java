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
 * La clase es abstracta
 * 
 * Las cuentas corrientes no son remuneradas, pero tienen asociada 
 * una lista de entidades autorizadas para
 * cobrar recibos domiciliados en la cuenta.
 */
public abstract class CuentaCorriente extends CuentaBancaria{

// atributo de la clase CuentaCorriente
    protected String entidadesAutorizadas;
    
// constructor de la clase CuentaCorriente         
    public CuentaCorriente (Persona titular, double saldo, String numberCuenta) {
    super (titular, saldo, numberCuenta);
    }
    
// getters y setters de la clase CuentaCorriente      
    public String getEntidadesAutorizadas() {
		return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(String entidadesAutorizadas) {
            this.entidadesAutorizadas = entidadesAutorizadas;
    }
}
