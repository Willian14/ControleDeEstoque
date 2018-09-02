/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.Dao;

import br.com.willian.conection.ConexaoFactory;
import br.com.willian.entity.Categoria;
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
public class CategoriaDao {
    
    private Connection con = ConexaoFactory.getConnection();
    private PreparedStatement preparador = null;
    private ResultSet rs = null;
    
    public void cadastrar(Categoria cat){
          String sql = " insert into categorias(nome_categoria) values(?)";
        
          try{
                    preparador = con.prepareStatement(sql);                
                    preparador.setString(1, cat.getNome());
                
                    preparador.execute();
                    preparador.close();
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Problemas na comunicação com o banco de dados!!!!");
          }
    }
    
    public void alterar(Categoria cat){
          String sql = "update categorias set nome_categoria = ? where cod_categoria = ?";
         
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, cat.getNome());
                    preparador.setInt(2, cat.getCod_categoria());
                    preparador.execute();
                    preparador.close();
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void salvar(Categoria c){
          if(c.getCod_categoria() != null){
                    alterar(c);
          }else{
                    cadastrar(c);
          }
    }
    
    public List<Categoria> buscarTodos(){
          List<Categoria> lista = new ArrayList<>();
          String sql = "select * from categorias";
        
          try{ 
                    preparador = con.prepareStatement(sql);
                    ResultSet rs = preparador.executeQuery();
            
                    while(rs.next()){
                              Categoria cat = new Categoria();
                              cat.setCod_categoria(rs.getInt("cod_categoria"));
                              cat.setNome(rs.getString("nome_categoria"));
                              lista.add(cat);
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public Categoria buscarPorNome(String nome){
          String sql = "select * from categorias where nome_categoria = ?";
   
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, nome);
                     rs = preparador.executeQuery();
                    Categoria cat = new Categoria();
                    if(rs != null ){
                              while(rs.next()){
                                        cat.setCod_categoria( rs.getInt("cod_categoria"));
                                        cat.setNome(rs.getString("nome_categoria"));
                              }
                    }
                    preparador.close();
                    return cat;
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
    
    public ArrayList buscarTodosParaTabela(){
          String sql = "select * from categorias order by cod_categoria";
          ArrayList lista = new ArrayList();
         
         try {
                    preparador = con.prepareStatement(sql);
                    rs = preparador.executeQuery();
                    
                    while(rs.next()){
                              lista.add(new Object[] {rs.getString("cod_categoria"), rs.getString("nome_categoria")});
                    }
                    preparador.close();
                    return lista;
          } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
}
