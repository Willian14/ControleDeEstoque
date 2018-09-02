/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.Dao;

import br.com.willian.conection.ConexaoFactory;
import br.com.willian.util.Formatacao;
import br.com.willian.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willian
 */
public class ProdutoDao {
    private Connection con = ConexaoFactory.getConnection();
    private PreparedStatement preparador = null;
    private ResultSet rs = null;
    
    public void cadastrarProduto(Produto p ){
          String sql = "insert into produtos (cod_produto,cod_marca,cod_modelo,cod_cor,cod_categoria,tamanho,preco_custo,preco_venda,"+
                    "lucro_liquido,margem_lucro,quantidade) values(?,?,?,?,?,?,?,?,?,?,?)";
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, p.getCod_produto());
                    preparador.setInt(2, p.getMarca().getCodMarca());
                    preparador.setInt(3, p.getModelo().getCod_modelo());
                    preparador.setInt(4, p.getCor().getCod_cor());
                    preparador.setInt(5, p.getCategoria().getCod_categoria());
                    preparador.setString(6, p.getTamanho());
                    preparador.setBigDecimal(7, p.getPreco_custo());
                    preparador.setBigDecimal(8, p.getPreco_venda());
                    preparador.setBigDecimal(9, p.getLucro_liquido());
                    preparador.setBigDecimal(10, p.getMargemLucro_liquido());
                    preparador.setInt(11, p.getQtd());
            
                    preparador.execute();
                    preparador.close();
                    System.out.println("Produto cadastrado com sucesso!!!");
          } catch (SQLException ex) {
            
                    System.out.println("Problemas na comunicação com o banco de dados!!!");
                    throw new RuntimeException(ex);
           
         }
    }
    
    public void alterarProduto(Produto p ){
          String sql = "update produtos  set cod_marca = ?, cod_modelo = ?" 
                    + ", cod_cor  = ?, cod_categoria = ?, tamanho = ?, preco_custo = ?, preco_venda = ?,"
                    +" lucro_liquido = ?, margem_lucro = ?, quantidade = ? where cod_produto = ?";
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setInt(1, p.getMarca().getCodMarca());
                    preparador.setInt(2, p.getModelo().getCod_modelo());
                    preparador.setInt(3, p.getCor().getCod_cor());
                    preparador.setInt(4, p.getCategoria().getCod_categoria());
                    preparador.setString(5, p.getTamanho());
                    preparador.setBigDecimal(6, p.getPreco_custo());
                    preparador.setBigDecimal(7, p.getPreco_venda());
                    preparador.setBigDecimal(8, p.getLucro_liquido());
                    preparador.setBigDecimal(9, p.getMargemLucro_liquido());
                    preparador.setInt(10, p.getQtd());
                    preparador.setString(11, p.getCod_produto());

                    preparador.execute();
                    System.out.println("Produto cadastrado com sucesso!!!");
                    preparador.close();
          } catch (SQLException ex) {
                    System.out.println("Problemas na comunicação com o banco de dados!!!");
                    throw new RuntimeException(ex);
          }
    }
    
    public void deletarProduto(String codigo){
          String sql = "delete from produtos where cod_produto = ?";
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, codigo);
                    preparador.execute();
                    preparador.close();
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
          } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public Boolean salvarProduto(Produto p,String acao){
          Boolean existe = false;
          Boolean limparCampos = true;
          existe = verificaSeExisteNoBanco(p.getCod_produto());
        
          if(existe == true && acao.equals("edit")){
                    alterarProduto(p);
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                    
          }else if(existe == true && acao.equals("cad")){              
                    JOptionPane.showMessageDialog(null, "Já existe um produto com o código " + p.getCod_produto() + " cadastrado no estoque! \n" + 
                              " por favor digite outro código.");
                    limparCampos = false;
                    
          }else{
                    cadastrarProduto(p);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
             
          }
          return limparCampos;
    }
    
    public Boolean verificaSeExisteNoBanco(String codigo){
          Boolean existe = false;
          String codigoBusca = null;
          String sql = "select  cod_produto from produtos where cod_produto = ?";
        
          try {
                    preparador = con.prepareStatement(sql);
                    preparador.setString(1, codigo);
                    rs = preparador.executeQuery();
            
                    if(rs.next()){
                              codigoBusca = rs.getString("cod_produto");
                    }
                      preparador.close();
            
                    if(codigoBusca != null){
                              existe = true;
                    }
                    preparador.close();
                    return existe;
         } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
         }
          return null;
    }
 
    public ArrayList buscaParaPreencherTabela(){
          String sql = "select  * from produtos,marcas,modelo,categorias,cores "
                    + "where produtos.cod_marca = marcas.cod_marca and "
                    +"produtos.cod_modelo = modelo.cod_modelo and " 
                    +"produtos.cod_categoria = categorias.cod_categoria and "
                    +"produtos.cod_cor = cores.cod_cor order by nome_categoria";
        
          ArrayList lista = new ArrayList();
          String str = null;
          try {
                    preparador = con.prepareStatement(sql);
            
                    rs = preparador.executeQuery();
            
                    while(rs.next()){
                              lista.add(new Object[]{rs.getString("cod_produto"),rs.getString("nome_marca")
                             ,rs.getString("nome_modelo"),rs.getString("nome_cor"),rs.getString("nome_categoria")
                             ,rs.getString("tamanho"),new String(Formatacao.formataValorDoBancoParaTabela( rs.getBigDecimal("preco_custo").toString()))
                             ,new String(Formatacao.formataValorDoBancoParaTabela(rs.getBigDecimal("preco_venda").toString())),
                              new String(Formatacao.formataValorDoBancoParaTabela(rs.getBigDecimal("lucro_liquido").toString())),
                              new String(Formatacao.formataValorDoBancoParaTabela(rs.getBigDecimal("margem_lucro").toString())),rs.getInt("quantidade")});
                    }
                    preparador.close();
                    return lista;
            
          } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
    }
   
}
