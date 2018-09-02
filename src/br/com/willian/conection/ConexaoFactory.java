/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.conection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class  ConexaoFactory {
        static String url = "jdbc:postgresql://localhost/controle_roupas";
        static String usuario = "postgres";
        static String senha = "210100";
        static  Connection con = null; 
     public static Connection getConnection(){
       
        try {
            Class.forName("org.postgresql.Driver");
            
            try {
                 con = DriverManager.getConnection(url, usuario, senha);
                System.out.println("Conexão realizada com sucesso!!!!");
            } catch (SQLException sQLException) {
                System.out.println("Problemas na conexão!!!");
            }
        } catch (ClassNotFoundException classNotFoundException) {
            
        }
      return con;
        
    }
}
