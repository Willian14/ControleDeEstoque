/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.entity;

import java.math.BigDecimal;

/**
 *
 * @author Willian
 */
public class Produto {
    private String cod_produto;
    private Marca marca;
    private Modelo modelo;
    private String tamanho;
    private Cor cor;
    private Categoria categoria;
    private BigDecimal preco_custo;
    private BigDecimal preco_venda;
    private BigDecimal lucro_liquido;
    private BigDecimal margemLucro_liquido;
    private Integer qtd;
    
    public Produto(){
        
    }
    
    public Produto(String cod_produto, Marca marca, Modelo modelo, String tamanho, 
                    Cor cor, Categoria categoria, BigDecimal preco_custo, BigDecimal preco_venda,
                    BigDecimal lucro_liquido, BigDecimal margemLucro_liquido, Integer qtd) {
        
          this.cod_produto = cod_produto;
          this.marca = marca;
          this.modelo = modelo;
          this.tamanho = tamanho;
          this.cor = cor;
          this.categoria = categoria;
          this.preco_custo = preco_custo;
          this.preco_venda = preco_venda;
          this.lucro_liquido = lucro_liquido;
          this.margemLucro_liquido = margemLucro_liquido;
          this.qtd = qtd;
    }
     
    public String getCod_produto() {
          return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
          this.cod_produto = cod_produto;
    }

    public Marca getMarca() {
          return marca;
    }

    public void setMarca(Marca marca) {
          this.marca = marca;
    }

    public Modelo getModelo() {
          return modelo;
    }

    public void setModelo(Modelo modelo) {
          this.modelo = modelo;
    }

    public String getTamanho() {
          return tamanho;
    }

    public void setTamanho(String tamanho) {
          this.tamanho = tamanho;
    }

    public Cor getCor() {
          return cor;
    }

    public void setCor(Cor cor) {
          this.cor = cor;
    }

    public BigDecimal getPreco_custo() {
          return preco_custo;
    }

    public void setPreco_custo(BigDecimal preco_custo) {
          this.preco_custo = preco_custo;
    }

    public BigDecimal getPreco_venda() {
          return preco_venda;
    }

    public void setPreco_venda(BigDecimal preco_venda) {
          this.preco_venda = preco_venda;
    }

    public BigDecimal getLucro_liquido() {
          return lucro_liquido;
    }

    public void setLucro_liquido(BigDecimal lucro_liquido) {
          this.lucro_liquido = lucro_liquido;
    }

    public BigDecimal getMargemLucro_liquido() {
          return margemLucro_liquido;
    }

    public void setMargemLucro_liquido(BigDecimal margemLucro_liquido) {
          this.margemLucro_liquido = margemLucro_liquido;
    }

    public Categoria getCategoria() {
          return categoria;
    }

    public void setCategoria(Categoria categoria) {
          this.categoria = categoria;
    }

    public Integer getQtd() {
          return qtd;
    }

    public void setQtd(Integer qtd) {
          this.qtd = qtd;
    }

    public BigDecimal calculaMargem(BigDecimal lucro, BigDecimal preco_custo){
          BigDecimal resultado =  lucro.divide(preco_custo,2,BigDecimal.ROUND_UP);
          BigDecimal margem = resultado.multiply(new BigDecimal("100"));
        
          return margem;
    }
      
    public BigDecimal calculaLucro(BigDecimal preco_venda,BigDecimal  preco_custo){
          BigDecimal result  = preco_venda.subtract(preco_custo);
          return result;
   }
      
     
}
