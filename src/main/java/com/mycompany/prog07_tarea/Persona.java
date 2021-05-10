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
 * clase Persona, la cual contendrá información sobre el titular: nombre, apellidos y DNI
 */
public class Persona {

//Atributos de la clase Persona
    	private String nombreTitular;
	private String apellidosTitular;
	private String dniTitular;
    
    //Genero el constructor
    public Persona (){}

    public Persona(String nombreTitular, String apellidosTitular, String dni) {
        this.nombreTitular = nombreTitular;
        this.apellidosTitular = apellidosTitular;
        this.dniTitular = dniTitular;
      
    }
    //Creo los getter y setter
    public String getNombreTitular() {
	return nombreTitular;
	}
    
    public String getApellidosTitular() {
	return apellidosTitular;
	}
    
    public String getDni() {
	return dniTitular;
	}
    public void setNombreTitular (String nombreTitular){
        this.nombreTitular=nombreTitular;
    }
    public void setApellidosTitular (String apellidosTitular){
        this.apellidosTitular= apellidosTitular;
    }
        public void setDniTitular (String dniTitular){
        this.dniTitular= dniTitular;
    }
            
}//Cierra Persona
