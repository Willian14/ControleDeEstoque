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
public class Cor {
    private Integer cod_cor;
    private String nome;
    
    public Cor(){
        
    }
    
    public Cor(Integer cod_cor,String nome){
          this.cod_cor = cod_cor;
          this.nome = nome;
    }
    
    
    public Integer getCod_cor() {
          return cod_cor;
    }

    public void setCod_cor(Integer cod_cor) {
          this.cod_cor = cod_cor;
    }

    public String getNome() {
          return nome;
    }

    public void setNome(String nome) {
          this.nome = nome;
    }
 
    
}
