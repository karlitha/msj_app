/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.msjes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Karlitha Bustos
 */
public class mensajesDAO {
    
    public static void crearMensajeDB(mensajes mensaje){
        conexion db_connect = new conexion();
        
        try (Connection conexion=db_connect.get_connection()){
            PreparedStatement ps=null;
            
            try {
                String query="INSERT INTO `mensajes` (mensaje,autor_msj) VALUES (?,?);";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
                
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
    
      public static void leerMensajeDB(){
          conexion db_connect = new conexion();
          PreparedStatement ps=null;
          ResultSet rs=null;
          
          try(Connection conexion=db_connect.get_connection()) {
              String query="SELECT * FROM mensajes";
              ps=conexion.prepareStatement(query);
              rs=ps.executeQuery();//pide datos de la base 
              
              while(rs.next()){//mientras rs.next tenga datos 
                  System.out.println("ID: "+rs.getInt("id_mensaje"));//esta parte nos trae id_mensaje de la base 
                  System.out.println("Mensaje: "+rs.getString("mensaje"));
                  System.out.println("Autor: "+rs.getString("autor_msj"));
                  System.out.println("Fecha: "+rs.getString("fecha_msj"));
                  System.out.println("");
                  
              }
              
              
          } catch (Exception e) {
              System.out.println("No se pudieron recuperar los mensajes");
              System.out.println(e);
          }
    }
      
        public static void borrarMensajeDB(int id_mensaje){
             conexion db_connect = new conexion();
        
          
          try(Connection conexion=db_connect.get_connection()) {
              PreparedStatement ps=null;
              
              try {
                  String query="DELETE FROM mensajes WHERE id_mensaje=?";//sea el id que nos va a llegar
                  ps=conexion.prepareStatement(query);
                  ps.setInt(1, id_mensaje);
                  ps.executeUpdate();
                  System.out.println("el mensaje a sido borrado");
              } catch (Exception e) {
                  System.out.println("no se pudo borrrar el mensaje");
              }
            
              
              
          } catch (Exception e) {
             System.out.println(e);
          }
            
    }
    
        
          public static void actualizarMensajeDB(mensajes mensaje){
                conexion db_connect = new conexion();
        
          
          try(Connection conexion=db_connect.get_connection()) {
              PreparedStatement ps=null;
            
              try {
                  String query="UPDATE mensajes SET mensaje=? WHERE id_mensaje=?";
                  ps=conexion.prepareStatement(query);
                  ps.setString(1, mensaje.getMensaje());
                  ps.setInt(2, mensaje.getId_mensaje());
                  ps.executeUpdate();
                  System.out.println("mensaje se actualizo correctamente");
              } catch (SQLException ex) {
                  ex.printStackTrace();
                  System.out.println(ex);
                  System.out.println("no se pudo actualizar el mensaje");
              }
              
          } catch (Exception e) {
             System.out.println(e);
          }
              
              
              
    }
    
    
}
