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
public class Modelo {
    private Integer cod_modelo;
    private String nome;

    public Modelo() {
        
    }

    public Modelo(Integer cod_modelo, String nome) {
          this.cod_modelo = cod_modelo;
          this.nome = nome;
    }
    
    public Modelo(String nome){
          this.nome = nome;
    }
      
    
    public Integer getCod_modelo() {
          return cod_modelo;
    }

    public void setCod_modelo(Integer cod_modelo) {
          this.cod_modelo = cod_modelo;
    }

    public String getNome() {
          return nome;
    }

    public void setNome(String nome) {
          this.nome = nome;
    }
    
    
}
