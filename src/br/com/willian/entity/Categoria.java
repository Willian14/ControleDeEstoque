/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.entity;

/**
 *
 * @author Willian
 */
public class Categoria {
    private Integer cod_categoria;
    private String nome;

    public Categoria(){
        
    }
    
    public Categoria(Integer cod_categoria,String nome){
          this.cod_categoria = cod_categoria;
          this.nome = nome;
    }
        
    public Integer getCod_categoria() {
          return cod_categoria;
    }

    public void setCod_categoria(Integer cod_categoria) {
          this.cod_categoria = cod_categoria;
    }

    public String getNome() {
          return nome;
    }

    public void setNome(String nome) {
          this.nome = nome;
    }
    
    
}
