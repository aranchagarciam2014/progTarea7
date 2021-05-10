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
 * Las cuentas corrientes de empresa, que no la tienen. Además, las cuentas de empresa permiten tener una
 * cierta cantidad de descubierto (máximo descubierto permitido) y por tanto un tipo de interés por
 * descubierto y una comisión fija por cada descubierto que se tenga. Es el único tipo de cuenta que permite
 * tener descubiertos.
 *  
 */
public class CuentaCorrienteEmpresas extends CuentaCorriente {

// atributos de la clase CuentaCorrienteEmpresa    
    private int maxDescubierto;
    private double interesDescubierto;
    private int comisionDescubierto;

// constructores de la clase CuentaCorrienteEmpresa    
    public CuentaCorrienteEmpresas (Persona titular, double saldo, String numberCuenta, String entidadesAutorizadas,int maxDescubierto, double interesDescubierto, int comisionDescubierto) {
    super (titular, saldo, numberCuenta);
    
        this.maxDescubierto = maxDescubierto;
        this.interesDescubierto =  interesDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }            
   
    
// getters y setters de la clase CuentaCorrienteEmpresa
    public int getMaxDescubierto() {
	return maxDescubierto;
    }

    public void setMaxDescubierto(int maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }
    
    public double getInteresDescubierto() {
	return interesDescubierto;
    }

    public void setInteresDescubierto(double interesDescubierto) {
        this.interesDescubierto = interesDescubierto;
    }
    
    public int getComisionDescubierto() {
        return comisionDescubierto;
    }

    public void setComisionDescubierto(int comisionDescubierto) {
        this.comisionDescubierto = comisionDescubierto;
    }
// método que devuelve los datos de una cuenta corriente de empresa
    public String devolverInfoString() {
        String datosCuentaEmpresas;
        datosCuentaEmpresas = "Los datos de la cuenta bancaria son: \n"
                                +"Nombre "+titular.getNombreTitular()+"\n"
                                +"Apellidos "+titular.getApellidosTitular()+"\n"
                                +"DNI "+titular.getDni()+"\n"
                                +"Saldo "+saldo+"\n"
                                +"IBAN "+numberCuenta+"\n"
                                +"Máximo descubierto permitido "+maxDescubierto+"\n"
                                +"Interés por descubierto "+interesDescubierto+"\n"
                                +"Comisión por descubierto "+comisionDescubierto+"\n";
        return datosCuentaEmpresas;
    }    
    
}
