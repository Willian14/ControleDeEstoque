/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.Dao;

import br.com.willian.conection.ConexaoFactory;
import br.com.willian.entity.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class ModeloDao {
    private Connection con = ConexaoFactory.getConnection();
    ResultSet rs;
    PreparedStatement  preparador;
    public void cadastrarModelo(Modelo modelo){
          String sql = "insert into modelo(nome_modelo)values(?)";
        
          try{
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, modelo.getNome());
            
                    preparador.execute();
                    preparador.close();
            
          } catch (SQLException ex) {
                    Logger.getLogger(ModeloDao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public List<Modelo> buscarTodos(){
          String sql = "select * from modelo";
          List<Modelo> lista = new ArrayList<>();
          try{
                    preparador = con.prepareStatement(sql);
                    ResultSet rs = preparador.executeQuery();
            
                    while(rs.next()){
                              Modelo mod = new Modelo();
                              mod.setCod_modelo(rs.getInt("cod_modelo"));
                              mod.setNome(rs.getString("nome_modelo"));
                
                              lista.add(mod);
                    }
                    preparador.close();
                    return lista;
           
          } catch (SQLException ex) {
                    Logger.getLogger(ModeloDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public Modelo buscarPorNome(String nome){
        String sql = "select * from modelo where nome_modelo = ?";
      
        try {
            preparador = con.prepareStatement(sql);
            preparador.setString(1, nome);
            
             rs = preparador.executeQuery();
              Modelo mod = new Modelo();
             if(rs != null){ 
                    while(rs.next()){
                        mod.setCod_modelo(rs.getInt("cod_modelo"));
                        mod.setNome(rs.getString("nome_modelo"));
                    }
             }
              preparador.close();
             return mod;
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList buscarTodosParaTabela(){
          String sql = "select * from modelo";
          ArrayList lista = new ArrayList();
         
         try {
                    preparador = con.prepareStatement(sql);
                    rs = preparador.executeQuery();
                    
                    while(rs.next()){
                              lista.add(new Object[] {rs.getString("cod_modelo"), rs.getString("nome_modelo")});
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public void alterar(Modelo mod){
          String sql = "update modelo set nome_modelo = ? where cod_modelo = ?";
          
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, mod.getNome());
                    preparador.setInt(2,mod.getCod_modelo());
                    preparador.execute();
                    preparador.close();
          } catch (SQLException ex) {
                    Logger.getLogger(ModeloDao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void salvar(Modelo mod){
          if(mod.getCod_modelo() != null){
                    alterar(mod);
          }else{
                    cadastrarModelo(mod);
          }
    }
}
