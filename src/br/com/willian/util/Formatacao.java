/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class Formatacao {
    
    public static String formataValorMonetarioParabanco(String valor){
        
          StringBuilder build = new StringBuilder(valor);
             
          for(int i = 0;i < build.length(); i ++){
                    if(build.charAt(i) == '.' || build.charAt(i) == ','){
                    build.deleteCharAt(i);
                   }
         }
             
          build.insert(build.length() - 2, '.');
          valor = build.toString();
        
          return valor;
    }
    
    public static String formataValorDoBancoParaTabela(String valor){
        
          StringBuilder build = new StringBuilder(valor);
          for(int i = 0;i < build.length();i++){
                   if(build.charAt(i) == '.'|| build.charAt(i) == ','){
                    build.deleteCharAt(i);
                   }
         }
      
          build.insert(build.length()-2,',' );
         
          if(build.length() > 6 && build.length() < 10){
                    build.insert(build.length() - 6, '.');
          }else if(build.length() >= 10){
                    build.insert(build.length() - 6, '.');
                    build.insert(build.length() - 10, '.');
         }
       
          valor = build.toString();
        
          return valor;
    }
    
    public static Boolean verificaSeTemApenasNumeros(String valor){
    
          String str = valor;
          Boolean valida  = false;
          StringBuilder build = new StringBuilder(str);
      
          for(int i = 0;i < build.length();i++){
                    if(build.charAt(i) == '.'|| build.charAt(i) == ','){
                    build.deleteCharAt(i);
                   }
         }
          str = build.toString();
          Integer numeros = 0;
          try {
                    numeros = Integer.parseInt(str);
                    valida = true;
                    return valida;
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Os campos de valor monetário devem conter apenas números");
        }
          return valida;
          
    }
    
    public static String mascaraTxtMonetario(String valor){
        
          String str = valor;
          StringBuilder build = new StringBuilder(str);
          
          for(int i = 0;i < build.length();i++){
                    if(build.charAt(i) == '.'|| build.charAt(i) == ','){
                    build.deleteCharAt(i);
                   }
         }
          if(build.length() <= 2){
              
                    build.insert(build.length() , '0');
                    build.insert(build.length() , '0');
         }
          
          build.insert(build.length() - 2, ',');
        
          if(build.length() > 6 && build.length() < 10){
              
                    build.insert(build.length() - 6, '.');
          }else if(build.length() >= 10){
              
                    build.insert(build.length() - 6, '.');
                    build.insert(build.length() - 10, '.');
         }
       
             
          valor = build.toString();
          return valor;
    }
}
