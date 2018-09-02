/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.teste;

import br.com.willian.Dao.CategoriaDao;
import br.com.willian.Dao.CorDao;
import br.com.willian.Dao.MarcaDao;
import br.com.willian.Dao.ModeloDao;
import br.com.willian.Dao.ProdutoDao;
import br.com.willian.entity.Categoria;
import br.com.willian.entity.Cor;
import br.com.willian.entity.Marca;
import br.com.willian.entity.Modelo;
import br.com.willian.entity.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Willian
 */
public class Teste {
    public static void main(String[] args) {
      //testeCadastroCategorias();
       //testeCadastroCores();
       //testeCadastroMarcas();
       //testeCadastroModelos();
       //testeCadastroProdutos();
       
       ProdutoDao pDao = new ProdutoDao();
       
        ArrayList lista = pDao.buscaParaPreencherTabela();
        
        for(int i = 0;i < lista.size(); i++){
           
           
        }
    
    }
    
    public static void testeCadastroCategorias(){
         Categoria cat1 = new Categoria();
        cat1.setNome("Calça Bailarina");
        CategoriaDao catDao = new CategoriaDao();
        catDao.cadastrar(cat1);
    }
    
     public static void testeCadastroCores(){
         Cor c = new Cor();
        c.setNome("Jeans normal");
         CorDao cDao = new CorDao();
         cDao.cadastrar(c);
    }
     
    public static void testeCadastroMarcas(){
         Marca m = new Marca();
         m.setNome("ArcoIris Mix");
         MarcaDao mDao = new MarcaDao();
         mDao.cadastrarMarca(m);
    }
    
      public static void testeCadastroModelos(){
          Modelo mod = new Modelo("Fitness");
          
          ModeloDao mDao = new ModeloDao();
          mDao.cadastrarModelo(mod);
    }
      
      public static void testeCadastroProdutos(){
        Marca marca = new Marca();
        marca.setCodMarca(1);
        Modelo mod = new Modelo();
        mod.setCod_modelo(1);
        Cor c = new Cor();
        c.setCod_cor(1);
        Categoria cat = new Categoria();
        cat.setCod_categoria(1);
        
        Produto p = new Produto("CJM01", marca, mod, "48", c, cat,
                new BigDecimal("49.90"), new BigDecimal("109.00"), BigDecimal.ZERO,
                BigDecimal.ZERO, 1);
        p.setLucro_liquido(p.calculaLucro(p.getPreco_venda(), p.getPreco_custo()));
        p.setMargemLucro_liquido(p.calculaMargem(p.getLucro_liquido(), p.getPreco_custo()));
        
          ProdutoDao pDao = new ProdutoDao();
          pDao.cadastrarProduto(p);
    }
    
}
