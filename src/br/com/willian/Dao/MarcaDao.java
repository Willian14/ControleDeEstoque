/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.Dao;

import br.com.willian.conection.ConexaoFactory;
import br.com.willian.entity.Marca;
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
public class MarcaDao {
    private Connection con = ConexaoFactory.getConnection();
    private PreparedStatement preparador = null;
    private ResultSet rs = null;
    
    public void cadastrarMarca(Marca marca){
          String sql = " insert into marcas(nome_marca)values(?)";
        
       
          try { 
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, marca.getNome());
            
                    preparador.execute();
                    preparador.close();
            
          } catch (SQLException ex) {
                    Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
           
          }
        
    }
    
    public List<Marca> buscarTodos(){
          String sql = "select * from marcas";
          List<Marca> lista = new ArrayList<>();
        
          try{ 
                    preparador = con.prepareStatement(sql);
                    ResultSet rs = preparador.executeQuery();
            
                    while(rs.next()){
                              Marca m = new Marca();
                              m.setCodMarca(rs.getInt("cod_marca"));
                              m.setNome(rs.getString("nome_marca"));
                
                              lista.add(m);
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
     public ArrayList buscarTodosComoObject(){
          String sql = "select * from marcas";
          ArrayList lista = new ArrayList();
        
          try{ 
                    preparador = con.prepareStatement(sql);
                    ResultSet rs = preparador.executeQuery();
            
                    while(rs.next()){
                              lista.add(new Object[] {rs.getInt("cod_marca"),rs.getString("nome_marca")});
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public Marca buscarPorNome(String nome){
          String sql = "select * from marcas where nome_marca = ?";
        
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, nome);
            
                    rs = preparador.executeQuery();
                    Marca m = new Marca();
                    if(rs != null){
                              while(rs.next()){
                                       m.setCodMarca(rs.getInt("cod_marca"));
                                       m.setNome(rs.getString("nome_marca"));
                              }
                    }
                    preparador.close();
                    return m;
          } catch (SQLException ex) {
                    Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public ArrayList buscarTodosParaTabela(){
          ArrayList lista = new ArrayList();
          String sql = "select * from marcas";
        
          try {
                    preparador = con.prepareStatement(sql);
                    rs = preparador.executeQuery();
                    
                    while(rs.next()){
                              lista.add(new Object[] {rs.getInt("cod_marca"),rs.getString("nome_marca")});
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public void alterar(Marca marca){
          String sql = "update marcas set nome_marca = ? where cod_marca = ?";
        
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, marca.getNome());
                    preparador.setInt(2, marca.getCodMarca());
                    preparador.execute();
                    preparador.close();
          } catch (SQLException ex) {
                    Logger.getLogger(MarcaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void salvar(Marca marca){
          if(marca.getCodMarca() != null){
                    alterar(marca);
          }else{
                    cadastrarMarca(marca);
          }
    }
}
