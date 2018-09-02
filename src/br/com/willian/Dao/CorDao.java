/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.Dao;

import br.com.willian.conection.ConexaoFactory;
import br.com.willian.entity.Cor;
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
public class CorDao {
    private Connection con = ConexaoFactory.getConnection();
    
    public void cadastrar(Cor cor){
          String sql = "insert into cores(nome_cor)values(?)";
        
          try (PreparedStatement preparador =  con.prepareStatement(sql)){
                    preparador.setString(1, cor.getNome());
            
                    preparador.execute();
                    preparador.close();
          } catch (SQLException ex) {
                    Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
                    
          }
        
    }
    
    public List<Cor> buscarTodos(){
          List<Cor> lista = new ArrayList<>();
          String sql = "select * from cores";
        
          try (PreparedStatement preparador = con.prepareStatement(sql)){
                    ResultSet rs = preparador.executeQuery();
            
                    while(rs.next()){
                              Cor cor = new Cor();
                              cor.setCod_cor(rs.getInt("cod_cor"));
                              cor.setNome(rs.getString("nome_cor"));
                              lista.add(cor);
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public Cor buscarPorNome(String nome){
          String sql = "select * from cores where nome_cor = ?";
        
          try (PreparedStatement preparador = con.prepareStatement(sql)){
                    preparador.setString(1, nome);
                    ResultSet rs = preparador.executeQuery();
                    Cor c = new Cor();
                    if(rs != null){
                              while(rs.next()){
                              c.setCod_cor(rs.getInt("cod_cor"));
                              c.setNome(rs.getString("nome_cor"));
                              }
                    }
                    preparador.close();
                    return c;
          } catch (SQLException ex) {
                    Logger.getLogger(CorDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
     public ArrayList buscarTodosParaTabela(){
         
          String sql = "select * from cores order by cod_cor";
          ArrayList lista = new ArrayList();
         
         try (PreparedStatement preparador = con.prepareStatement(sql)){
                    ResultSet rs = preparador.executeQuery();
                    
                    while(rs.next()){
                              lista.add(new Object[] {rs.getString("cod_cor"), rs.getString("nome_cor")});
                    }
                    
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
     
      public void alterar(Cor cor){
          String sql = "update cores set nome_cor = ? where cod_cor = ?";
         
          try {
                    PreparedStatement preparador = con.prepareStatement(sql);
                    preparador.setString(1, cor.getNome());
                    preparador.setInt(2, cor.getCod_cor());
                    preparador.execute();
                    preparador.close();
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void salvar(Cor cor){
          if(cor.getCod_cor() != null){
                    alterar(cor);
          }else{
                    cadastrar(cor);
          }
    } 
}
