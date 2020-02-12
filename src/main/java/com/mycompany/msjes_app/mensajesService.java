/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.msjes_app;

import java.util.Scanner;

/**
 *
 * @author Karlitha Bustos
 */
public class mensajesService {
    
    public static void crearMensaje(){
       Scanner sc= new Scanner(System.in);
        System.out.println("Escribe mensaje");
        String mensaje=sc.nextLine();
        
        System.out.println("Tu nombre");
        String nombre=sc.nextLine();
        
        mensajes registro=new mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        
        //mandamos a traer la clase crearMensaje para pasarle los valores 
        //mediante el objecto registro
        
        mensajesDAO.crearMensajeDB(registro);
        
    
    
    }
     public static void listarMensajes(){
         mensajesDAO.leerMensajeDB();
    
    }
    
    
    public static void borrarMensaje(){
      Scanner sc=new Scanner(System.in);
        System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje=sc.nextInt();
        
        mensajesDAO.borrarMensajeDB(id_mensaje);
        
      
        
        
    }
    
    public static void editarMensaje(){
       Scanner sc=new Scanner(System.in);
       
        System.out.println("escribe tu nuevo mensaje");
        String mensaje=sc.nextLine();
        
        System.out.println("indica el ID del mensaje");
        int id_mensaje=sc.nextInt();
        mensajes actualizacion=new mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setId_mensaje(id_mensaje);
        mensajesDAO.actualizarMensajeDB(actualizacion);
        
    
    }
    
}
