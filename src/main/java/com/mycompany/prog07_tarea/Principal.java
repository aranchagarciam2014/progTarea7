package com.mycompany.prog07_tarea;

import java.util.Scanner;

/**
 *
 * @author AranchaGarcía
 */
public class Principal {
    
    static Scanner scn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
/*
 * MENÚ PRINCIPAL
 * 1. Abrir una nueva cuenta.
 * 2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).
 * 3. Obtener los datos de una cuenta concreta.
 * 4. Realizar un ingreso en una cuenta.
 * 5. Retirar efectivo de una cuenta.
 * 6. Consultar el saldo actual de una cuenta.
 * 7. Salir de la aplicación.
 * */   
        //declaro las variables que voy a necesitar
        int option;
        int optTipoCuenta;
        String nombreTitular, apellidosTitular, dni;
        boolean cuentaCreada=false;
        String entidadesAutorizadas;
        Double newSaldo;
        
        // objetos para crear el banco y sus tipos de cuentas
            Banco banco = new Banco();

        do {
            System.out.println("*********BIENVENIDO AL BANCO BURGLARS*********");
            System.out.println("1. Abrir una nueva cuenta.");
            System.out.println("2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual)");
            System.out.println("3. Obtener los datos de una cuenta concreta.");
            System.out.println("4. Realizar un ingreso en una cuenta.");
            System.out.println("5. Retirar efectivo de una cuenta.");
            System.out.println("6. Consultar el saldo actual de una cuenta.");
            System.out.println("7. Salir de la aplicación.");
            System.out.println("Elige un número del 1 al 7, de las opciones del menú");
            
            //lee la opción introducida por teclado
            option = scn.nextInt();

            //limpiar el intro
	    scn.nextLine(); 
            
            switch(option){
                //1. Abrir una nueva cuenta
                case 1:
                    System.out.println("****Usted ha seleccionado Abrir una cuenta nueva****");
                    
                    System.out.println("Indica el nombre del titular ");
                    nombreTitular = scn.nextLine();
                    
                    System.out.println("Introduce los apellidos");
                    apellidosTitular = scn.nextLine();
                    
                    System.out.println("Introduce el DNI");
                    dni = scn.nextLine();
                    
                //Añadimos los datos del titular al objeto persona
                    Persona persona = new Persona();
                    persona.setNombreTitular(nombreTitular);
                    persona.setApellidosTitular(apellidosTitular);
                    persona.setDniTitular(dni);
                
                    //Solicitamos el saldo inicial
                    System.out.println("Saldo inicial para abrir la cuenta");
                        double saldo = scn.nextDouble();
                        scn.nextLine();

                    //Validamos el IBAN
                    String numberIban = null;
                    while (numberIban == null) {
                        try {
                            System.out.println("Introduzaca un IBAN");
                            numberIban = scn.nextLine();
                            Validar.validarIban(numberIban);                 
                        } catch (Exception e) {
                            System.out.println(e.getMessage());               
                            numberIban = null;
                        }
               
                        //Solicitamos el tipo de cuenta que se quiere crear con un menú
                        do{
                            System.out.println("*********** TIPO DE CUENTA BANCARIA ***********");
                            System.out.println("1. Cuenta ahorro");
                            System.out.println("2. Cuenta corriente personal");
                            System.out.println("3. Cuenta corriente empresa");
                            System.out.println("********* Introduzca una opción entre 1 y 3 *********");
                            
                            //lee la opción introducida por teclado
                            optTipoCuenta = scn.nextInt();
                            
                            //limpiar el intro
                            scn.nextLine();
                            
                            switch(optTipoCuenta){
                                
                                //cuenta ahorro
                                case 1:
                                    System.out.println("**** Interés remunerado ****");
                                    System.out.println("Introduzca un tipo de interés remunerado");
                                    double tipoDeInteres = scn.nextDouble();
                                    scn.nextLine();
                                    //Creo un objeto de CuentaAhorro para almacenar el tipo de interés introducido
                                    CuentaAhorro cuentaA = new CuentaAhorro(persona,saldo, numberIban, tipoDeInteres);
                                    //guardar en el banco la cuenta con sus datos
                                    cuentaCreada=banco.abrirCuenta(cuentaA);
                                    if (cuentaCreada){
                                        System.out.println("Se ha creado correctamente su cuenta de ahorro");
                                    }else {
                                        System.out.println("No hay sitio para más cuentas");
                                    }
                                    break;
                                                                    
                                //cuenta corriente personal
                                case 2:
                                    System.out.println("****Entidades autorizadas****");
                                    System.out.println("Introduzca las entidades autorizadas");
                                    entidadesAutorizadas = scn.next();
                                    //scn.nextLine();
                                    System.out.println("**** Comisión de mantenimiento ****");
                                    System.out.println("Introduzca la comisión de mantenimiento");
                                    double comisionMantenimiento = scn.nextDouble();
                                    scn.nextLine();
                                    //Creo un objeto de CuentaCorrientePersonal para almacenar los datos introducidos
                                    CuentaCorrientePersonal cuentaB = new CuentaCorrientePersonal(persona, saldo, numberIban, entidadesAutorizadas, comisionMantenimiento);
                                    //guardar en el banco con los datos
                                    cuentaCreada=banco.abrirCuenta(cuentaB);
                                    if (cuentaCreada){
                                        System.out.println("Se ha creado correctamente su cuenta corriente personal");
                                    }else {
                                        System.out.println("No hay sitio para más cuentas");
                                    }
                                    break;
                                    
                                
                                //cuenta corriente empresa    
                                case 3:
                                    System.out.println("****Entidades autorizadas****");
                                    System.out.println("Introduzca las entidades autorizadas");
                                    entidadesAutorizadas = scn.next();
                                    scn.nextLine();
                                    System.out.println("Introduzca el máximo descubierto permitido: ");
                                        int maxDescubierto = scn.nextInt();
                                        scn.nextLine();
                                    
                                    System.out.println("Introduzca el tipo interés por descubierto: ");
                                       double interesDescubierto = scn.nextDouble();
                                       scn.nextLine();
                                    
                                    System.out.println("Introduzca la comisión fija por descubierto: ");
                                        int comisionDescubierto = scn.nextInt();
                                        scn.nextLine();
                                    //Creo un objeto de cuenta ahorro para almacenar los datos introducidos
                                    CuentaCorrienteEmpresas cuentaC = new CuentaCorrienteEmpresas(persona,saldo, numberIban,entidadesAutorizadas, maxDescubierto, interesDescubierto, comisionDescubierto);
                                    //guardar en el banco
                                     cuentaCreada=banco.abrirCuenta(cuentaC);
                                     if (cuentaCreada){
                                     System.out.println("Se ha creado correctamente su cuenta corriente de empresa");
                                     }else {
                                     System.out.println("No hay sitio para más cuentas");
                                     }
                                    break;
                            default:System.out.println("No es una opción correcta");
                            }//Cierra switch(optTipoCuenta)
                        //System.out.println("La cuenta corriente se ha creado con éxito.");   
                        }while (optTipoCuenta != 1 && optTipoCuenta !=2 && optTipoCuenta != 3);
                 
                }
                break;
                /*
                Seguimos con el resto del menú del empleado del banco. Se ha planteado para realizar una serie de operaciones
                del menú, que en caso de no haber cuentas introducidas en el banco, te da un aviso.
                */   
                case 2:
                    // 2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual)
                    if (!banco.sinCuentas()) {  
                            System.out.println("****Ha elegido ver el listado de cuentas disponibles****");
                            for (int i=0; i<banco.listadoCuentas().length; i++){
                                System.out.println(banco.listadoCuentas()[i]);
                            }
                    } 
                    else {
                            System.out.println("No hay ninguna cuenta para mostrar");
                    }
                    break;
                
                case 3:
                    // 3. Obtener los datos de una cuenta concreta  
                    if (!banco.sinCuentas()) {  
                            System.out.println("****Ha elegido ver los datos de una cuenta****");
                            System.out.println("Introduzca IBAN: ");
                            String ibanCuenta = scn.next();
                            scn.nextLine();
                            String cuentaBuscada = banco.informacionCuenta(ibanCuenta);
                            if (cuentaBuscada == null) 
                                    System.out.println("La cuenta no se ha encontrado.");
                            else
                                    System.out.println(cuentaBuscada);

                    } else {
                            System.out.println("No hay ninguna cuenta en el banco.");
                    }
                    break;
                
                case 4:
                    // 4. Realizar un ingreso en una cuenta
                    if (!banco.sinCuentas()) {   
                            System.out.println("****Ha elegido hacer un ingreso en una cuenta****");
                            System.out.println("Introduzca un IBAN ");
                            String ibanCuenta = scn.next();
                            scn.nextLine();

                            String cuentaBuscada = banco.informacionCuenta(ibanCuenta);
                            if (cuentaBuscada == null) 
                                    System.out.println("La cuenta no se ha encontrado.");

                            else {   
                                    System.out.println("Introduzca la cantidad a ingresar: ");
                                    double ingreso = scn.nextInt();
                                    scn.nextLine();
                                    // se realiza el ingreso en el banco
                                    banco.ingresoCuenta(ibanCuenta, ingreso);
                                    //se muestra el nuevo saldo por teclado
                                    newSaldo=banco.obtenerSaldo(ibanCuenta);
                                    System.out.println("El nuevo saldo de su cuenta es "+newSaldo);
                            }
                    } else {
                            System.out.println("No hay ninguna cuenta para ingresar.");
                    }
                    break;
                
                case 5:
                    // 5. Retirar efectivo de una cuenta
                    if (!banco.sinCuentas()) {
                            System.out.println("****Ha elegido retirar dinero de una cuenta****");
                            System.out.println("Introduzca un IBAN ");
                            String ibanCuenta = scn.next();
                            scn.nextLine();

                            String cuentaBuscada = banco.informacionCuenta(ibanCuenta);
                            if (cuentaBuscada == null) 
                                    System.out.println("La cuenta no se ha encontrado.");

                            else {   
                                    System.out.println("Introduce la cantidad a retirar: ");
                                    double retirada = scn.nextInt();
                                    scn.nextLine();
                                    // se realiza el ingreso en el banco
                                    banco.retiradaCuenta(ibanCuenta, retirada);
                                    //se muestra el nuevo saldo por teclado
                                    newSaldo=banco.obtenerSaldo(ibanCuenta);
                                    System.out.println("El nuevo saldo de su cuenta es "+newSaldo);
                            }
                    } else {
                            System.out.println("No hay ninguna cuenta para retirar.");
                    }
                    break;
                
                case 6:
                    // 6. Consultar el saldo actual de una cuenta
                    if (!banco.sinCuentas()) {
                            System.out.println("****Ha elegido consultar el saldo de una cuenta.");
                                System.out.println("Introduzac un IBAN ");
                            String ibanCuenta = scn.next();
                            scn.nextLine();
                            saldo = banco.obtenerSaldo(ibanCuenta);
                            if (saldo == -1) 
                                    System.out.println("La cuenta no se ha encontrado.");
                            else
                                    System.out.println("El saldo de la cuenta es "+saldo);

                    } else {
                            System.out.println("No hay ninguna cuenta para consultar el saldo.");
                    }
                    break;
                
                case 7:
                    //7. Salir
                    System.out.println("SAYONARA, BABY");
                    break;
                
                default:
                System.out.println("No es una opción correcta");
            
            }//Cierra Switch 

        }while(option != 7);//Cierra do
  
    }//Cierra Main
      
}//Cierra Principal
