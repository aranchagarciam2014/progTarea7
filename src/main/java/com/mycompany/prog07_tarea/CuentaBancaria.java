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
 * La clase es abstracta e implementa la interface Imprimible
 */
public abstract class CuentaBancaria implements Imprimible {

//Atributos de la clase Cuenta Bancaria
    protected Persona titular;
    protected double saldo;
    protected String numberCuenta; // Es el IBAN con ES y 20 números
    
//Constructor de la clase CuentaBancaria
    public CuentaBancaria() {
    }

public CuentaBancaria(Persona titular, double saldo, String numberCuenta ) {
        this.titular = titular;
        this.saldo = saldo;
        this.numberCuenta = numberCuenta;
}
// getters y setters de la clase CuentaBancaria
	public Persona getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNumberCuenta() {
		return numberCuenta;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setNumberCuenta(String numberCuenta) {
		this.numberCuenta = numberCuenta;
	}
        
}