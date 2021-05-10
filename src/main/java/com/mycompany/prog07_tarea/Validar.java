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
public class Validar {
    public static boolean validarIban (String ibanCuenta) throws Exception {
            if (!ibanCuenta.matches("^ES[0-9]{20}$")){
               throw new Exception("El IBAN introducido no es correcto."); 
            }else {
                System.out.println("El IBAN es correcto");
            }
            return false;
	
    }
}
