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
 * 
 */
public class Banco {
    
    //genero un atributo array de tipo CuentaBancaria
    private CuentaBancaria [] cuentas;
    /*el segundo atributo de la clase Banco es contador 
    * que nos sirve para saber cuántas cuentas hay
    */
    private int contador;
    
    //redacto el constructor de la clase Banco
       public Banco () {
    
        this.cuentas = new CuentaBancaria [100];
        this.contador = 0;
    }
    
/*Creo un método para confirmar que se puede abrir la cuenta
* Pero tengo que saber qué tipo de cuenta voy a abrir,
* esto se añade en la clase principal
*/
    public boolean abrirCuenta (CuentaBancaria cb) {
        if (contador >=100){
            return false;
        }
        else {
            cuentas [contador]= cb;
            contador++;
            return true;
        }
    }
    
    //No recibe parámetro y muestra la informacion de cada una de las cuentas
    public String [] listadoCuentas (){
        
        String lista []= new String [contador];
        
        for (int i = 0; i< contador; i++){
            lista [i]=cuentas [i].devolverInfoString();
        }
        return lista;
    }
       
    //recibe un iban por parámetro y devuelve una cadena con la informacion de la cuenta o null si la cuenta no existe    
    public String informacionCuenta (String ibanCuenta){
                   
        for (int i = 0; i< contador; i++){
        
            if (cuentas [i].getNumberCuenta().equals(ibanCuenta)){
                return cuentas [i].devolverInfoString();
            }
        }
        return null;
    }

    //recibe un iban por parámetro y una cantidad e ingresa la cantidad en la cuenta    
    public boolean ingresoCuenta (String ibanCuenta, double ingreso){
        
        boolean ingresoCuenta = true;
        double newSaldo;
        
        for (int i = 0; i< contador; i++) {	
            if (cuentas [i].getNumberCuenta().equals(ibanCuenta)) {
                    if (ingreso < 0) {
			ingresoCuenta = false;
			} 
                        else {
			// se suma el ingreso al saldo.
			newSaldo = cuentas [i].getSaldo() + ingreso;
			// se actualiza el saldo de la cuenta localizada.
			cuentas [i].setSaldo(newSaldo);
			ingresoCuenta = true;
			}
                    }
            }
	return ingresoCuenta;
    }
    //método para retirar dinero de la cuenta indicada por Iban   
    public boolean retiradaCuenta (String ibanCuenta, double retirada){
        
        boolean retiradaCuenta = true;
        double newSaldo;
        
        for (int i = 0; i< contador; i++) {	
            if (cuentas [i].getNumberCuenta().equals(ibanCuenta)) {
                if (retirada < 0) {
                    retiradaCuenta = false;
                } 
                else{
                    if (retirada<= cuentas [i].getSaldo()){
                        // se suma el ingreso al saldo.
                        newSaldo = cuentas [i].getSaldo() - retirada;
                        //actualiza el saldo de la cuenta
                        cuentas [i].setSaldo(newSaldo);
                        retiradaCuenta = true;
                    }else {
                        retiradaCuenta = false;
                    }
                }
            }
        }
	return retiradaCuenta;
    }

    // Recibe un iban por parámetro y devuelve el saldo de la cuenta si existe 
    //En caso contrario devuelve -1
    public double obtenerSaldo (String ibanCuenta) {
        
        for (int i = 0; i< contador; i++) {
            if (cuentas [i].getNumberCuenta().equals(ibanCuenta)) {
                return cuentas [i].getSaldo();  
            }
        }
        return -1;
    }     
    //Creo un método por si el banco esta vacío que salte una alerta y no se pude ejecutar
    public boolean sinCuentas() {
        
        if (contador == 0)
                return true;	
        else 
                return false;
    }
    
}//Cierra Banco
